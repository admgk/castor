package com.ignismark.castor.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ignismark.castor.data.Exercise
import com.ignismark.castor.data.local.LocalExercisesDataProvider.exercises

@Composable
fun CastorExerciseDetailsScreen(
    castorUiState: CastorUiState,
    paddingValues: PaddingValues
) {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .padding(paddingValues)
    ) {
        ExerciseDetailsCard(exercises[0])
    }
}

@Composable
fun ExerciseDetailsCard(exercise: Exercise) {
    Card(
        border = BorderStroke(1.dp, Color.LightGray),
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 32.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 24.dp)
        ) {
            Text(
                text = String.format("%s", exercise.name),
                modifier = Modifier
                    .padding(bottom = 16.dp),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = String.format("MUSCLE GROUP: %s", exercise.muscleGroup),
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )
            Text(
                text = String.format("EQUIPMENT: %s", exercise.equipment),
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )
            Text(
                text = String.format("COUNT TYPE: %s", exercise.countType),
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CastorExerciseDetailsScreenPreview() {
    CastorExerciseDetailsScreen(
        castorUiState = CastorUiState(),
        paddingValues = PaddingValues()
    )
}