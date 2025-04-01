package com.ignismark.castor.data.database

import com.ignismark.castor.model.Workout
import kotlinx.coroutines.flow.Flow

class OfflineWorkoutsRepository(private val workoutDao: WorkoutDao) : WorkoutsRepository {
    override suspend fun insertWorkout(workout: Workout) =
        workoutDao.insertWorkout(workout)

    override suspend fun updateWorkout(workout: Workout) =
        workoutDao.updateWorkout(workout)

    override suspend fun deleteWorkout(workout: Workout) =
        workoutDao.deleteWorkout(workout)

    override fun getAllWorkoutsStream(): Flow<List<Workout>> =
        workoutDao.getAllWorkouts()
}