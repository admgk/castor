package com.ignismark.castor.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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