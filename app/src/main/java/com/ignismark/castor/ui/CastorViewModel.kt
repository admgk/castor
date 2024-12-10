package com.ignismark.castor.ui

import androidx.lifecycle.ViewModel
import com.ignismark.castor.data.Exercise
import com.ignismark.castor.data.local.LocalExercisesDataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CastorViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CastorUiState())
    val uiState: StateFlow<CastorUiState> = _uiState

    init {
        initializeUiState()
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
}