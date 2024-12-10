package com.ignismark.castor.ui

import androidx.activity.compose.BackHandler
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ignismark.castor.data.Exercise
import com.ignismark.castor.utils.CastorContentType

@Composable
fun CastorBooksListScreen(
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
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(
                    start = if (contentType == CastorContentType.ListAndDetails) 32.dp else 16.dp,
                    top = 4.dp,
                    end = 16.dp,
                    bottom = 4.dp
                )
            ) {
                items(listOf(Exercise(name = "book1 title", equipment = "book1 data", countType = "book1 pages", muscleGroup = "book1 genre"),
                    Exercise(name = "book2 title", equipment = "book2 data", countType = "book2 pages", muscleGroup = "book2 genre"))
                ) { book ->
                    BookCard(exercise = book)
                }
            }
        }
    }
}

@Composable
fun BookCard(
    exercise: Exercise,
) {
    Card(border = BorderStroke(1.dp, Color.LightGray),
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
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