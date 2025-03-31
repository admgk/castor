package com.ignismark.castor.data.local

import com.ignismark.castor.model.Workout
import com.ignismark.castor.model.WorkoutItem
import java.time.LocalDate
import java.util.UUID
import kotlin.time.Duration

object LocalWorkoutDataProvider {
    val workout: Workout = Workout(
        workoutId = UUID.randomUUID().toString(),
        date = LocalDate.now(),
        name = "WORKOUT",
        workoutItems = listOf(
            WorkoutItem.ExerciseItem(
                exercise = LocalExercisesDataProvider.exercises[0]
            ),
            WorkoutItem.ExerciseItem(
                exercise = LocalExercisesDataProvider.exercises[1]
            ),
            WorkoutItem.SupersetItem(
                superset = LocalSupersetDataProvider.superset
            )
        ),
        duration = Duration.parse("PT45M"),
    )




}
