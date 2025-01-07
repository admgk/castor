package com.ignismark.castor.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CastorTopBar(
    castorViewModel: CastorViewModel,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = "CASTOR")
        },
        navigationIcon =  {
            IconButton(onClick = { castorViewModel.toggleIsDialogVisible() }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "menu")
            }
        },
        actions = {
            IconButton(onClick = { castorViewModel.toggleIsDialogVisible() }) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "account")
            }
        },
        modifier = modifier
    )
}

@Composable
fun CastorBottomNavigation(
    castorUiState: CastorUiState,
    castorViewModel: CastorViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(
        modifier = modifier
    ) {
        NavigationBarItem(
            selected = currentRoute == CastorAppScreen.Calendar.title,
            onClick = { navController.navigate(CastorAppScreen.Calendar.title) },
            icon = {
                Icon(
                    imageVector = Icons.Filled.DateRange,
                    contentDescription = "calendar")
            },
            label = { 
                Text(text = "Calendar") 
            }
        )
        NavigationBarItem(
            selected = currentRoute == CastorAppScreen.Plan.title,
            onClick = { castorViewModel.toggleIsDialogVisible() },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = "plan")
            },
            label = {
                Text(text = "Plan")
            }
        )
        NavigationBarItem(
            selected = castorUiState.isLibraryDialogVisible ||
                    currentRoute == CastorAppScreen.ExercisesList.title ||
                    currentRoute == CastorAppScreen.ExerciseDetails.title,
            onClick = { castorViewModel.toggleIsLibraryDialogVisible() },
            icon = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.List,
                    contentDescription = "library")
            },
            label = {
                Text(text = "Library")
            }
        )
    }

    if (castorUiState.isLibraryDialogVisible) {
        LibraryDialog(
            castorViewModel = castorViewModel,
            closeDialog = { castorViewModel.toggleIsLibraryDialogVisible() },
            navController = navController
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AvailableSoonDialog(
    closeDialog: () -> Unit,
) {
    BasicAlertDialog(
        onDismissRequest = closeDialog
    ) {
        Surface(
            modifier = Modifier,
            shape = MaterialTheme.shapes.large,
            tonalElevation = AlertDialogDefaults.TonalElevation
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text =
                    "Available soon...",
                )
                Spacer(modifier = Modifier.height(24.dp))
                TextButton(
                    onClick = closeDialog,
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("Confirm")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibraryDialog(
    castorViewModel: CastorViewModel,
    closeDialog: () -> Unit,
    navController: NavController
) {
    BasicAlertDialog(
        onDismissRequest = closeDialog
    ) {
        Surface(
            modifier = Modifier,
            shape = MaterialTheme.shapes.large,
            tonalElevation = AlertDialogDefaults.TonalElevation
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row {
                    OutlinedButton(
                        onClick = {
                            closeDialog()
                            navController.navigate(CastorAppScreen.ExercisesList.title)
                        }
                    ) {
                        Text(text = "Exercises")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    OutlinedButton(
                        onClick = {  }
                    ) {
                        Text(text = "Workouts")
                    }
                }
                OutlinedButton(
                    onClick = {
                        closeDialog()
                        castorViewModel.getFitnessBooks()
                        navController.navigate(CastorAppScreen.BooksList.title)
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "Books")
                }
                TextButton(
                    onClick = closeDialog,
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("Exit")
                }
            }
        }
    }
}
