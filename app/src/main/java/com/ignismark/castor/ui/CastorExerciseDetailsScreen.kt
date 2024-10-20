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
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ignismark.castor.data.Exercise
import com.ignismark.castor.utils.CastorContentType

@Composable
fun CastorExerciseDetailsScreen(
    castorUiState: CastorUiState,
    navController: NavController,
    contentType: CastorContentType,
    paddingValues: PaddingValues
) {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .padding(paddingValues)
    ) {
        ExerciseDetailsCard(
            exercise = castorUiState.currentSelectedExercise,
            contentType = contentType,
            navigateBack = { navController.navigate(CastorAppScreen.ExercisesList.title) }
        )
    }
}

@Composable
fun ExerciseDetailsCard(
    modifier: Modifier = Modifier,
    exercise: Exercise,
    contentType: CastorContentType,
    navigateBack: () -> Unit
) {
    Card(
        border = BorderStroke(1.dp, Color.LightGray),
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 32.dp,
                top = if (contentType == CastorContentType.ListAndDetails) 4.dp else 32.dp,
                end = 32.dp,
                bottom = 32.dp
                )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 24.dp,
                    top = 24.dp,
                    end = 24.dp
                )
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
        TextButton(
            onClick = navigateBack,
            modifier = Modifier.padding(start = 12.dp, bottom = 16.dp)
        ) {
            Text(text = "Back")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CastorExerciseDetailsScreenPreview() {
    CastorExerciseDetailsScreen(
        castorUiState = CastorUiState(),
        navController = rememberNavController(),
        contentType = CastorContentType.ListAndDetails,
        paddingValues = PaddingValues()
    )
}