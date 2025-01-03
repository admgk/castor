package com.ignismark.castor.ui

import com.ignismark.castor.data.Book
import com.ignismark.castor.data.Exercise
import com.ignismark.castor.data.local.LocalExercisesDataProvider

data class CastorUiState(
    val exercisesAll: List<Exercise> = emptyList(),
    val fitnessBooks: List<Book> = emptyList(),
    val currentSelectedExercise: Exercise = LocalExercisesDataProvider.defaultExercise,
    val datePicked: String = "",
    val isDialogVisible: Boolean = false,
    val isLibraryDialogVisible: Boolean = false
)