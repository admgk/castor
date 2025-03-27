package com.ignismark.castor.model

import java.time.LocalDate
import kotlin.time.Duration

data class Workout(
    val workoutId: String,
    val userId: String,
    val date: LocalDate,
    val name: String = "WORKOUT",
    val notes: String? = null,
    val workoutItems: List<WorkoutItem> = emptyList(),
    val duration: Duration,
    val intensity: Intensity
)

enum class Intensity {
    LOW, MEDIUM, HIGH
}

sealed class WorkoutItem {
    data class ExerciseItem(val exercise: Exercise) : WorkoutItem()
    data class SupersetItem(val superset: Superset) : WorkoutItem()
}