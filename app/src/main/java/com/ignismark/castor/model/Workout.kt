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
) {
    override fun toString(): String {
        return "workoutId: $workoutId\n" +
                "userId: $userId\n" +
                "date: $date\n" +
                "name: $name\n" +
                "notes: $notes\n" +
                "workoutItems: ${workoutItems[2]}\n" +
                "duration: $duration\n" +
                "intensity: $intensity\n"
    }
}

enum class Intensity {
    LOW, MEDIUM, HIGH
}

sealed class WorkoutItem {
    data class ExerciseItem(val exercise: Exercise) : WorkoutItem()
    data class SupersetItem(val superset: Superset) : WorkoutItem()
}