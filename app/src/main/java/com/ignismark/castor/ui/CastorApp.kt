package com.ignismark.castor.ui

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ignismark.castor.ui.theme.CastorTheme

@Composable
fun CastorApp() {
    Scaffold(
        topBar = {
            CastorTopBar()
        },
        bottomBar = {
            CastorBottomNavigation()
        }
    ) { paddingValues ->
        CastorCalendarScreen(paddingValues = paddingValues)
    }
}

@Preview(showBackground = true)
@Composable
fun CastorPreview() {
    CastorTheme {
        CastorApp()
    }
}