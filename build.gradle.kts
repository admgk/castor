buildscript {
    extra.apply {
        set("room_version", "2.6.1")
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "2.1.0" apply false // Added for serialization
    id("com.google.devtools.ksp") version "2.1.10-1.0.31" apply false //Added for KSP
    alias(libs.plugins.compose.compiler) apply false
}

val defaultMinSdkVersion by extra(26)