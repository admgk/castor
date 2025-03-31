package com.ignismark.castor.ui

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ignismark.castor.data.local.LocalWorkoutDataProvider
import com.ignismark.castor.model.Workout
import com.ignismark.castor.model.Set
import com.ignismark.castor.model.WorkoutItem
import com.ignismark.castor.model.WorkoutItem.ExerciseItem
import com.ignismark.castor.model.WorkoutItem.SupersetItem
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
            Text(
                    text = workout.duration.toString(),
            textAlign = TextAlign.Center
            )
        }

        LazyColumn {
            items(workout.workoutItems) { item ->
                WorkoutItemCard(item = item)
            }
        }

        OutlinedButton(
            onClick = { Log.i(
                "Castor",
                workout.toString())
            }
        ) {
            Text(text = "Print Log's")
        }
    }
}

@Composable
fun WorkoutItemCard(
    item: WorkoutItem
) {
    Card(border = BorderStroke(1.dp, Color.LightGray),
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp)
    ) {
        if (item is ExerciseItem) {
            val exercise = item.exercise
            Column {
                Text(
                    text = exercise.name.toString(),
                    textAlign = TextAlign.Center,
                )
                Row {
                    exercise.parameters.forEach {
                        Text(text = it.toString())
                    }
                }
                exercise.sets.forEach {
                    SetItem(set = it)
                }
                HorizontalDivider()
            }
        } else if (item is SupersetItem) {
            val superset = item.superset
            Row {
                for (exercise in superset.exercises) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = exercise.name.toString(),
                            textAlign = TextAlign.Center,
                        )
                        Row {
                            exercise.parameters.forEach {
                                Text(text = it.toString())
                            }
                        }
                        exercise.sets.forEach {
                            SetItem(set = it)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SetItem(set: Set) {
    Row {
        if (set.reps != null) {
            Text(text = set.reps.toString())
        }
        if (set.weight != null) {
            Text(text = set.weight.toString())
        }
        if (set.duration != null) {
            Text(text = set.duration.toString())
        }
        if (set.distance != null) {
            Text(text = set.distance.toString())
        }
    }
}
