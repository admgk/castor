package com.ignismark.castor.data.database

import com.ignismark.castor.model.Workout
import kotlinx.coroutines.flow.Flow

interface WorkoutsRepository {
    suspend fun insertWorkout(workout: Workout)

    suspend fun updateWorkout(workout: Workout)

    suspend fun deleteWorkout(workout: Workout)

    fun getAllWorkoutsStream(): Flow<List<Workout>>
}