package com.ignismark.castor.data.local

import com.ignismark.castor.model.Equipment
import com.ignismark.castor.model.Exercise
import com.ignismark.castor.model.ExerciseParameter
import com.ignismark.castor.model.MuscleGroup
import com.ignismark.castor.model.Set
import kotlin.time.Duration


object LocalExercisesDataProvider {
    val exercises: List<Exercise> = listOf(
        Exercise(
            name = "Dumbbell Squat",
            equipment = Equipment.DUMBBELL,
            muscleGroup = MuscleGroup.LEGS,
            sets = listOf(
                Set(
                    reps = 10,
                    weight = 100.0
                ),
                Set(
                    reps = 9,
                    weight = 100.0
                ),
                Set(
                    reps = 8,
                    weight = 100.0
                )
            ),
            parameters = listOf(
                ExerciseParameter.REPS,
                ExerciseParameter.WEIGHT
            ),
            interSetRest = Duration.parse("PT1M")
        ),
        Exercise(
            name = "Dumbbell Chest Press",
            equipment = Equipment.DUMBBELL,
            muscleGroup = MuscleGroup.CHEST,
            sets = listOf(
                Set(
                    reps = 10,
                    weight = 25.0
                ),
                Set(
                    reps = 9,
                    weight = 25.0
                ),
                Set(
                    reps = 8,
                    weight = 25.0
                )
            ),
            parameters = listOf(
                ExerciseParameter.REPS,
                ExerciseParameter.WEIGHT
            ),
            interSetRest = Duration.parse("PT2M")
        ),
        Exercise(
            name = "Push-up",
            equipment = Equipment.NONE,
            muscleGroup = MuscleGroup.CHEST,
            sets = listOf(
                Set(
                    reps = 25
                ),
                Set(
                    reps = 20
                ),
                Set(
                    reps = 15
                )
            ),
            parameters = listOf(
                ExerciseParameter.REPS
            ),
            interSetRest = Duration.parse("PT2M")
        ),
        Exercise(
            name = "Pull-up",
            equipment = Equipment.BAR,
            muscleGroup = MuscleGroup.BACK,
            sets = listOf(
                Set(
                    reps = 9,
                    weight = 12.5
                ),
                Set(
                    reps = 8,
                    weight = 12.5
                ),
                Set(
                    reps = 8,
                    weight = 12.5
                )
            ),
            parameters = listOf(
                ExerciseParameter.REPS,
                ExerciseParameter.WEIGHT
            ),
            interSetRest = Duration.parse("PT1M")
        )
    )
    val defaultExercise = exercises[0]
}