package com.ignismark.castor

import android.app.Application
import com.ignismark.castor.data.AppContainer
import com.ignismark.castor.data.DefaultAppContainer

class CastorApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}