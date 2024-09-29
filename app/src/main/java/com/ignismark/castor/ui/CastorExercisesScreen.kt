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
import com.ignismark.castor.data.Exercise
import com.ignismark.castor.data.local.LocalExercisesDataProvider.exercises

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

