package com.ignismark.castor.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ignismark.castor.data.local.LocalWorkoutDataProvider
import com.ignismark.castor.model.Attempt
import com.ignismark.castor.model.Workout
import com.ignismark.castor.model.Set
import com.ignismark.castor.utils.CastorContentType

@Composable
fun CastorWorkoutScreen(
    castorUiState: CastorUiState,
    castorViewModel: CastorViewModel,
    navController: NavController,
    contentType: CastorContentType,
    paddingValues: PaddingValues
) {
    BackHandler {
        navController.popBackStack(route = CastorAppScreen.Calendar.title, inclusive = false)
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Column {
            WorkoutInfoCard(workout = LocalWorkoutDataProvider.workout)
        }
    }
}

@Composable
fun WorkoutInfoCard(
    workout: Workout
) {
    Card(border = BorderStroke(1.dp, Color.LightGray),
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp)
    ) {
        Column {
            Text(
                text = "WORKOUT",
                textAlign = TextAlign.Center,
            )
            Text(
                text = workout.date.toString(),
                textAlign = TextAlign.Center,
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "${workout.startTime} - ${workout.endTime}",
                    textAlign = TextAlign.Center
                )
                Text(
                    text = workout.duration.toString(),
                    textAlign = TextAlign.Center
                )
            }
        }

        LazyColumn {
            items(workout.sets) { set ->
                SetCard(set = set)
            }
        }
    }
}

@Composable
fun SetCard(
    set: Set
) {
    Card(border = BorderStroke(1.dp, Color.LightGray),
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp)
    ) {
        Column {
            Text(
                text = "SET, " + "Rest: ${set.rest}",
                textAlign = TextAlign.Center,
            )
            set.attempts.forEach {
                AttemptItem(attempt = it)
            }
            HorizontalDivider()
        }
    }
}

@Composable
fun AttemptItem(attempt: Attempt) {
    Column {
        Text(text = attempt.exercise.name)
        Text(text = attempt.reps.toString())
    }
}
