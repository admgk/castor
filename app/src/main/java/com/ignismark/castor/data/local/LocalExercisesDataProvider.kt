package com.ignismark.castor.data.local

import com.ignismark.castor.model.CountType
import com.ignismark.castor.model.Exercise

object LocalExercisesDataProvider {
    val exercises: List<Exercise> = listOf(
        Exercise(
            name = "Dumbbell Lateral Press",
            equipment = "Dumbbell",
            countType = CountType.REPS_AND_WEIGHT,
            muscleGroup = "Chest"
        ),
        Exercise(
            name = "Push-up",
            equipment = "Bodyweight",
            countType = CountType.REPS_AND_WEIGHT,
            muscleGroup = "Chest"
        ),
        Exercise(
            name = "Dumbbell Squat",
            equipment = "Dumbbell",
            countType = CountType.REPS_AND_WEIGHT,
            muscleGroup = "Legs"
        ),
        Exercise(
            name = "Kettlebell swing",
            equipment = "Kettlebell",
            countType = CountType.TIME_AND_WEIGHT,
            muscleGroup = "All"
        )
    )

    val defaultExercise = exercises[0]
}