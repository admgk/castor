package com.ignismark.castor.data.database

import android.content.Context

interface AppContainer {
    val workoutsRepository: WorkoutsRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val workoutsRepository: WorkoutsRepository by lazy {
        OfflineWorkoutsRepository(WorkoutDatabase.getDatabase(context).workoutDao())
    }
}