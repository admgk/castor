package com.ignismark.castor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import com.ignismark.castor.ui.CastorApp
import com.ignismark.castor.ui.theme.CastorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CastorTheme {
                val windowSize = currentWindowAdaptiveInfo().windowSizeClass
                CastorApp(
                    windowWidth = windowSize.windowWidthSizeClass
                )
            }
        }
    }
}
