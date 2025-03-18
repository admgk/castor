package com.ignismark.castor.data.local

import com.ignismark.castor.model.Exercise

object LocalExercisesDataProvider {
    val exercises: List<Exercise> = listOf(
        Exercise(
            name = "Dumbbell Lateral Press",
            equipment = "Dumbbell",
            countType = "Weight and Reps",
            muscleGroup = "Chest"
        ),
        Exercise(
            name = "Push-up",
            equipment = "Bodyweight",
            countType = "Reps",
            muscleGroup = "Chest"
        ),
        Exercise(
            name = "Dumbbell Squat",
            equipment = "Dumbbell",
            countType = "Weight and Reps",
            muscleGroup = "Legs"
        )
    )

    val defaultExercise = exercises[0]
}