package com.ignismark.castor.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.ignismark.castor.CastorApplication
import com.ignismark.castor.data.BookItem
import com.ignismark.castor.model.Exercise
import com.ignismark.castor.data.FitnessBooksRepository
import com.ignismark.castor.data.database.WorkoutsRepository
import com.ignismark.castor.data.local.LocalBookDataProvider
import com.ignismark.castor.data.local.LocalExercisesDataProvider
import com.ignismark.castor.model.Workout
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class CastorViewModel(
    private val fitnessBooksRepository: FitnessBooksRepository,
    private val workoutsRepository: WorkoutsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(CastorUiState())
    val uiState: StateFlow<CastorUiState> = _uiState

    init {
        initializeUiState()
    }

    fun getFitnessBooks() {
        viewModelScope.launch {
            try {
                val nestedJson = fitnessBooksRepository.getFitnessBooks()
                _uiState.update {
                    it.copy(
                        fitnessBooks = nestedJson.items
                    )
                }
            } catch (e: IOException) {
                _uiState.update {
                    it.copy(
                        fitnessBooks = LocalBookDataProvider.book
                    )
                }
            } catch (e: HttpException) {
                _uiState.update {
                    it.copy(
                        fitnessBooks = LocalBookDataProvider.book
                    )
                }
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
                        as CastorApplication)
                val fitnessBooksRepository = application.container.fitnessBooksRepository
                val workoutsRepository = application.container.workoutsRepository
                CastorViewModel(
                    fitnessBooksRepository = fitnessBooksRepository,
                    workoutsRepository = workoutsRepository
                )
            }
        }
    }

    private fun initializeUiState() {
        _uiState.value =
            CastorUiState(
                exercisesAll = LocalExercisesDataProvider.exercises
            )
    }

    fun updateCurrentSelectedExercise(selectedExercise: Exercise) {
        _uiState.update {
            it.copy(
                currentSelectedExercise = selectedExercise
            )
        }
    }

    fun toggleIsDialogVisible() {
        _uiState.update {
            it.copy(
                isDialogVisible = !it.isDialogVisible
            )
        }
    }

    fun toggleIsLibraryDialogVisible() {
        _uiState.update {
            it.copy(
                isLibraryDialogVisible = !it.isLibraryDialogVisible
            )
        }
    }

    fun prepareImageURL(bookItem: BookItem): String {
        return bookItem.volumeInfo.imageLinks.thumbnail.replace("http", "https")
    }

    suspend fun insertWorkout(workout: Workout) {
        workoutsRepository.insertWorkout(workout)
    }
}