package com.ignismark.castor.model

import kotlin.time.Duration

data class Exercise(
    val name: String? = null,
    val equipment: Equipment? = null,
    val muscleGroup: MuscleGroup? = null,
    val notes: String? = null,
    val sets: List<Set> = emptyList(),
    val parameters: List<ExerciseParameter>,
    val interSetRest: Duration? = null
)

enum class ExerciseParameter {
    REPS, WEIGHT, DURATION, DISTANCE, NONE
}

enum class Equipment {
    BARBELL, DUMBBELL, KETTLEBELL, BAND, BAR, NONE
}

enum class MuscleGroup {
    CHEST, BACK, ARMS, LEGS, CORE, NONE
}
