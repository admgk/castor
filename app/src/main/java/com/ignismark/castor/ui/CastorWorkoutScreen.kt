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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ignismark.castor.data.local.LocalExercisesDataProvider
import com.ignismark.castor.data.local.LocalWorkoutDataProvider
import com.ignismark.castor.model.Exercise
import com.ignismark.castor.model.Set
import com.ignismark.castor.model.Workout
import com.ignismark.castor.utils.CastorContentType
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.UUID
import kotlin.time.Duration.Companion.seconds

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
            WorkoutInfoCard(
                workout = LocalWorkoutDataProvider.workout,
                castorViewModel = castorViewModel
            )
        }
    }
}

@Composable
fun WorkoutInfoCard(
    workout: Workout,
    castorViewModel: CastorViewModel
) {
    val coroutineScope = rememberCoroutineScope()

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
            items(LocalExercisesDataProvider.exercises) { exercise ->
                ExerciseCard(exercise = exercise)
            }
        }

        OutlinedButton(
            onClick = {
                coroutineScope.launch {
                    castorViewModel.insertWorkout(
                        Workout(
                            workoutId = UUID.randomUUID().toString(),
                            date = LocalDate.now(),
                            name = "FBW - dumbbell",
                            exercises = listOf(
                                UUID.randomUUID().toString(),
                                UUID.randomUUID().toString(),
                                UUID.randomUUID().toString(),
                                UUID.randomUUID().toString()
                            ),
                            duration = 600L.seconds
                        )
                    )
                }
            }
        ) {
            Text(text = "Save workout")
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
fun ExerciseCard(
    exercise: Exercise
) {
    Card(border = BorderStroke(1.dp, Color.LightGray),
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp)
    ) {
        if (exercise.inSuperset) {
            Row {
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
        } else {
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
