package com.ignismark.castor.ui

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import com.ignismark.castor.ui.theme.CastorTheme

@Composable
fun CastorApp(
    windowWidth: WindowWidthSizeClass
) {

    val viewModel: CastorViewModel = viewModel()
    val castorUiState = viewModel.uiState.collectAsState().value
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            CastorTopBar(
                castorViewModel = viewModel
            )
        },
        bottomBar = {
            CastorBottomNavigation(
                castorViewModel = viewModel,
                navController = navController)
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = CastorAppScreen.Calendar.title
        ) {
            composable(route = CastorAppScreen.Calendar.title) {
                CastorCalendarScreen(
                    castorUiState = castorUiState,
                    paddingValues = paddingValues
                )
            }
            composable(route = CastorAppScreen.ExercisesList.title) {
                CastorExercisesListScreen(
                    castorUiState = castorUiState,
                    castorViewModel = viewModel,
                    navController = navController,
                    windowWidth = windowWidth,
                    paddingValues = paddingValues
                )
            }
            composable(route = CastorAppScreen.ExerciseDetails.title) {
                CastorExerciseDetailsScreen(
                    castorUiState = castorUiState,
                    navController = navController,
                    paddingValues = paddingValues
                )
            }
        }

        if (castorUiState.isDialogVisible) {
            AvailableSoonDialog(
                closeDialog = { viewModel.toggleIsDialogVisible() }
            )
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
        CastorApp(
            windowWidth = WindowSizeClass.compute(999.0F, 999F).windowWidthSizeClass
        )
    }
}