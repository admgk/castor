package com.ignismark.castor.ui

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ignismark.castor.ui.theme.CastorTheme

@Composable
fun CastorApp() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            CastorTopBar()
        },
        bottomBar = {
            CastorBottomNavigation(navController = navController)
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = CastorAppScreen.Calendar.title
        ) {
            composable(route = CastorAppScreen.Calendar.title) {
                CastorCalendarScreen(paddingValues = paddingValues)
            }
            composable(route = CastorAppScreen.ExercisesList.title) {
                CastorExercisesListScreen(paddingValues = paddingValues)
            }
            composable(route = CastorAppScreen.ExerciseDetails.title) {
                CastorExerciseDetailsScreen(paddingValues = paddingValues)
            }
        }
    }
}

enum class CastorAppScreen(val title: String) {
    Calendar(title = "calendar"),
    Plan(title = "plan"),
    ExercisesList(title = "exercisesList"),
    ExerciseDetails(title = "exerciseDetails")
}

@Preview(showBackground = true)
@Composable
fun CastorPreview() {
    CastorTheme {
        CastorApp()
    }
}