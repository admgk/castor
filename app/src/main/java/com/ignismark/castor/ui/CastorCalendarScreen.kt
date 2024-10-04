package com.ignismark.castor.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CastorCalendarScreen(
    castorUiState: CastorUiState,
    paddingValues: PaddingValues
) {
    Surface(modifier = Modifier.padding(paddingValues)) {
        CastorDatePicker()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CastorDatePicker() {
    val datePickerState = rememberDatePickerState()
    DatePicker(state = datePickerState)
}