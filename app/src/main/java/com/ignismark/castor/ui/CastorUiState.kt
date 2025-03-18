package com.ignismark.castor.ui

import com.ignismark.castor.data.BookItem
import com.ignismark.castor.model.Exercise
import com.ignismark.castor.data.local.LocalExercisesDataProvider

data class CastorUiState(
    val exercisesAll: List<Exercise> = emptyList(),
    val fitnessBooks: List<BookItem> = emptyList(),
    val currentSelectedExercise: Exercise = LocalExercisesDataProvider.defaultExercise,
    val datePicked: String = "",
    val isDialogVisible: Boolean = false,
    val isLibraryDialogVisible: Boolean = false
)