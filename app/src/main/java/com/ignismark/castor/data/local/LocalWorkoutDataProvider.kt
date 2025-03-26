package com.ignismark.castor.data.local

import com.ignismark.castor.data.local.LocalExercisesDataProvider
import com.ignismark.castor.model.Attempt
import com.ignismark.castor.model.Set
import com.ignismark.castor.model.Workout
import java.time.LocalDate
import java.time.LocalTime
import kotlin.time.Duration

object LocalWorkoutDataProvider {
    val workout: Workout =
        Workout(
            date = LocalDate.of( 2025,  3,  19),
            startTime = LocalTime.of(14,  30),
            endTime = LocalTime.of(15,  18),
            duration = Duration.parse("58m"),
            sets = listOf(
                Set(
                    /*results = mapOf(
                        LocalExercisesDataProvider.exercises[0] to RepsAndWeight(
                            reps = 10,
                            weight = 100.0
                        ),
                    ),*/
                    attempts = listOf(
                        Attempt(
                            exercise = LocalExercisesDataProvider.exercises[0],
                            reps = 10.0,
                            weight = 100.0,
                            time = null,
                            distance = null
                        ),
                        Attempt(
                            exercise = LocalExercisesDataProvider.exercises[0],
                            reps = 10.0,
                            weight = 100.0,
                            time = null,
                            distance = null
                        ),
                        Attempt(
                            exercise = LocalExercisesDataProvider.exercises[0],
                            reps = 10.0,
                            weight = 100.0,
                            time = null,
                            distance = null
                        )
                    ),
                    rest = Duration.parse("1m")
                ),
                Set(
                    attempts = listOf(
                        Attempt(
                            exercise = LocalExercisesDataProvider.exercises[1],
                            reps = 10.0,
                            weight = 100.0,
                            time = null,
                            distance = null
                        ),
                        Attempt(
                            exercise = LocalExercisesDataProvider.exercises[1],
                            reps = 10.0,
                            weight = 100.0,
                            time = null,
                            distance = null
                        ),
                        Attempt(
                            exercise = LocalExercisesDataProvider.exercises[1],
                            reps = 10.0,
                            weight = 100.0,
                            time = null,
                            distance = null
                        )
                    ),
                    rest = Duration.parse("2m")
                ),
                Set(
                    attempts = listOf(
                        Attempt(
                            exercise = LocalExercisesDataProvider.exercises[3],
                            reps = null,
                            weight = 24.0,
                            time = Duration.parse("1m"),
                            distance = null
                        ),
                        Attempt(
                            exercise = LocalExercisesDataProvider.exercises[3],
                            reps = null,
                            weight = 24.0,
                            time = Duration.parse("1m"),
                            distance = null
                        ),
                        Attempt(
                            exercise = LocalExercisesDataProvider.exercises[3],
                            reps = null,
                            weight = 24.0,
                            time = Duration.parse("1m"),
                            distance = null
                        )
                    ),
                    rest = Duration.parse("1m")
                )
            )
        )
}