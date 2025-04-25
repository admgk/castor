package com.ignismark.castor.data.local

import com.ignismark.castor.model.Workout
import java.time.LocalDate
import java.util.UUID
import kotlin.time.Duration

object LocalWorkoutDataProvider {
    val workout: Workout = Workout(
        workoutId = UUID.randomUUID().toString(),
        dateString = "2007-12-03",
        name = "WORKOUT",
        exercises =
            LocalExercisesDataProvider.exercises[0].exerciseId + "," +
            LocalExercisesDataProvider.exercises[1].exerciseId + "," +
            LocalExercisesDataProvider.exercises[2].exerciseId + "," +
            LocalExercisesDataProvider.exercises[3].exerciseId,
        durationString = "PT45M"
    )




}
