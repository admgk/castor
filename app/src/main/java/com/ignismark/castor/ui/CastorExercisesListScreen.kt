package com.ignismark.castor.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ignismark.castor.data.Exercise
import com.ignismark.castor.data.local.LocalExercisesDataProvider.exercises

@Composable
fun CastorExercisesListScreen(
    castorUiState: CastorUiState,
    paddingValues: PaddingValues
) {
    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)
    ) {
        LazyColumn(contentPadding = PaddingValues(4.dp)) {
            items(exercises) { exercise ->
                ExerciseCard(exercise)
            }
        }
    }
}

@Composable
fun ExerciseCard(exercise: Exercise) {
    Card(onClick = { /*TODO*/ },
        border = BorderStroke(1.dp, Color.LightGray),
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = exercise.name,
                textAlign = TextAlign.Left,
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        end = 8.dp,
                        top = 16.dp,
                        bottom = 16.dp
                    )
            )
            Text(
                text = exercise.muscleGroup,
                textAlign = TextAlign.Right,
                modifier = Modifier
                    .padding(
                        start = 8.dp,
                        end = 16.dp,
                        top = 16.dp,
                        bottom = 16.dp
                    )
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CastorExercisesScreenPreview() {
    CastorExercisesListScreen(
        castorUiState = CastorUiState(),
        paddingValues = PaddingValues()
    )
}

