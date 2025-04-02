package com.ignismark.castor.model

import androidx.room.PrimaryKey
import kotlin.time.Duration

data class Exercise(
    @PrimaryKey
    val exerciseId: String,
    val name: String? = null,
    val equipment: Equipment? = null,
    val muscleGroup: MuscleGroup? = null,
    val notes: String? = null,
    val sets: List<Set> = emptyList(),
    val parameters: List<ExerciseParameter>,
    val interSetRest: Duration? = null,
    val inSuperset: Boolean = false,
    val coupledExerciseId: String? = null
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
