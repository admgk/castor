package com.ignismark.castor.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CastorTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = "CASTOR")
        },
        navigationIcon =  {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "menu")
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
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
    navController: NavController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
    ) {
        NavigationBarItem(
            selected = true,
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
            selected = false,
            onClick = { /*TODO*/ },
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
            selected = false,
            onClick = { navController.navigate(CastorAppScreen.ExercisesList.title) },
            icon = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.List,
                    contentDescription = "exercises")
            },
            label = {
                Text(text = "Exercises")
            }
        )
    }
}