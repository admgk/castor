package com.ignismark.castor.data.local

import com.ignismark.castor.model.Exercise
import com.ignismark.castor.model.RepsAndWeight

object LocalExercisesDataProvider {
    val exercises: List<Exercise> = listOf(
        Exercise(
            name = "Dumbbell Lateral Press",
            equipment = "Dumbbell",
            countType = RepsAndWeight(null, null),
            muscleGroup = "Chest"
        ),
        Exercise(
            name = "Push-up",
            equipment = "Bodyweight",
            countType = RepsAndWeight(null, 0.0),
            muscleGroup = "Chest"
        ),
        Exercise(
            name = "Dumbbell Squat",
            equipment = "Dumbbell",
            countType = RepsAndWeight(null, null),
            muscleGroup = "Legs"
        )
    )

    val defaultExercise = exercises[0]
}