package com.ignismark.castor.ui

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import java.util.Calendar

@Composable
fun CastorCalendarScreen(
    castorUiState: CastorUiState,
    castorViewModel: CastorViewModel,
    paddingValues: PaddingValues
) {
    val activity = LocalContext.current as Activity
    BackHandler {
        activity.finish()
    }

    Surface(modifier = Modifier.padding(paddingValues)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CastorDatePicker()
            OutlinedButton(
                onClick = { castorViewModel.toggleIsDialogVisible() }
            ) {
                Text(text = "Add workout")    
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CastorDatePicker() {
    val rightNow = Calendar.getInstance()
    val datePickerState = rememberDatePickerState(initialSelectedDateMillis = rightNow.timeInMillis)
    DatePicker(state = datePickerState)
}