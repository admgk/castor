package com.ignismark.castor.ui

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.window.core.layout.WindowWidthSizeClass
import com.ignismark.castor.ui.theme.CastorTheme
import com.ignismark.castor.utils.CastorContentType

@Composable
fun CastorApp(
    windowWidth: WindowWidthSizeClass
) {
    val viewModel: CastorViewModel = viewModel(factory = CastorViewModel.Factory)
    val castorUiState = viewModel.uiState.collectAsState().value
    val navController = rememberNavController()
    val contentType = when (windowWidth) {
        WindowWidthSizeClass.COMPACT,
        WindowWidthSizeClass.MEDIUM -> CastorContentType.ListOnly
        WindowWidthSizeClass.EXPANDED -> CastorContentType.ListAndDetails
        else -> CastorContentType.ListOnly
    }

    Scaffold(
        topBar = {
            CastorTopBar(
                castorViewModel = viewModel
            )
        },
        bottomBar = {
            CastorBottomNavigation(
                castorUiState = castorUiState,
                castorViewModel = viewModel,
                navController = navController)
        }
    ) { paddingValues ->

        NavigateToListFromDetailsOnScreenRotation(navController, contentType)

        NavHost(
            navController = navController,
            startDestination = CastorAppScreen.Calendar.title
        ) {
            composable(route = CastorAppScreen.Calendar.title) {
                CastorCalendarScreen(
                    castorUiState = castorUiState,
                    castorViewModel = viewModel,
                    navController = navController,
                    paddingValues = paddingValues
                )
            }
            composable(route = CastorAppScreen.ExercisesList.title) {
                CastorExercisesListScreen(
                    castorUiState = castorUiState,
                    castorViewModel = viewModel,
                    navController = navController,
                    contentType = contentType,
                    paddingValues = paddingValues
                )
            }
            composable(route = CastorAppScreen.ExerciseDetails.title) {
                CastorExerciseDetailsScreen(
                    castorUiState = castorUiState,
                    navController = navController,
                    contentType = contentType,
                    paddingValues = paddingValues
                )
            }
            composable(route = CastorAppScreen.BooksList.title) {
                CastorBooksListScreen(
                    castorUiState = castorUiState,
                    castorViewModel = viewModel,
                    navController = navController,
                    paddingValues = paddingValues
                )
            }
            composable(route = CastorAppScreen.Workout.title) {
                CastorWorkoutScreen(
                    castorUiState = castorUiState,
                    castorViewModel = viewModel,
                    navController = navController,
                    contentType = contentType,
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

@Composable
private fun NavigateToListFromDetailsOnScreenRotation(
    navController: NavHostController,
    contentType: CastorContentType
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    if (
        contentType == CastorContentType.ListAndDetails &&
        currentRoute == CastorAppScreen.ExerciseDetails.title
    )
        navController.navigate(CastorAppScreen.ExercisesList.title)
}

enum class CastorAppScreen(val title: String) {
    Calendar(title = "calendar"),
    Plan(title = "plan"),
    ExercisesList(title = "exercisesList"),
    ExerciseDetails(title = "exerciseDetails"),
    BooksList(title = "books"),
    Workout(title = "workout")
}

@Preview(showBackground = true)
@Composable
fun CastorPreview() {
    CastorTheme {
        CastorApp(
            windowWidth = WindowWidthSizeClass.COMPACT
        )
    }
}