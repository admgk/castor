package com.ignismark.castor.ui

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun CastorCalendarScreen(
    castorUiState: CastorUiState,
    paddingValues: PaddingValues
) {
    val activity = LocalContext.current as Activity
    BackHandler {
        activity.finish()
    }

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