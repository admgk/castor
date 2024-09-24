package com.ignismark.castor.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CastorExercisesScreen(paddingValues: PaddingValues) {
    Surface(modifier = Modifier.padding(paddingValues)) {
        LazyColumn {
            items(exercises) { exercise ->
                ExerciseCard(exercise)
            }
        }
    }
}

@Composable
fun ExerciseCard(exercise: Exercise) {
    Card(onClick = { /*TODO*/ }) {
        Text(text = exercise.name)
    }
}

val exercises: List<Exercise> = listOf(
    Exercise(
        name = "Dumbbell Lateral Press",
        equipment = "Dumbbell",
        countType = "Weight and Reps",
        muscleGroup = "Chest"
    ),
    Exercise(
        name = "Push-up",
        equipment = "Bodyweight",
        countType = "Reps",
        muscleGroup = "Chest"
    ),
    Exercise(
        name = "Dumbbell Squat",
        equipment = "Dumbbell",
        countType = "Weight and Reps",
        muscleGroup = "Legs"
    )
)

data class Exercise(
    val name: String,
    val equipment: String,
    val countType: String,
    val muscleGroup: String
)