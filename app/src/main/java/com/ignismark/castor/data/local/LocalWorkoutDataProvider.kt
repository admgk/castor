package com.ignismark.castor.data.local

import android.os.Build
import androidx.annotation.RequiresApi
import com.ignismark.castor.model.Attempt
import com.ignismark.castor.model.RepsAndWeight
import com.ignismark.castor.model.Set
import com.ignismark.castor.model.Workout
import java.time.LocalDate
import java.time.LocalTime
import kotlin.time.Duration

object LocalWorkoutDataProvider {
    @RequiresApi(Build.VERSION_CODES.O)
    val workout: Workout =
        Workout(
            date = LocalDate.of( 2025,  3,  19),
            startTime = LocalTime.of(14,  30),
            endTime = LocalTime.of(15,  18),
            duration = Duration.parse("58m"),
            sets = listOf(
                Set(
                    rest = Duration.parse("1m"),
                    attempts = listOf(
                        Attempt(
                            exercise = LocalExercisesDataProvider.exercises[0],
                            amount = RepsAndWeight(
                                reps = 10,
                                weight = 100.0
                            )
                        ),
                        Attempt(
                            exercise = LocalExercisesDataProvider.exercises[0],
                            amount = RepsAndWeight(
                                reps = 9,
                                weight = 100.0
                            )
                        ),
                        Attempt(
                            exercise = LocalExercisesDataProvider.exercises[0],
                            amount = RepsAndWeight(
                                reps = 8,
                                weight = 100.0
                            )
                        )
                    )
                )
            )

        )
}