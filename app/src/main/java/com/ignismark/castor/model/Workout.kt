package com.ignismark.castor.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import kotlin.time.Duration

@Entity(tableName = "workouts")
data class Workout(
    @PrimaryKey
    val workoutId: String,
    val date: LocalDate,
    val name: String = "WORKOUT",
    val notes: String? = null,
    val workoutItems: List<WorkoutItem> = emptyList(),
    val duration: Duration,
) {
    override fun toString(): String {
        return "workoutId: $workoutId\n" +
                "date: $date\n" +
                "name: $name\n" +
                "notes: $notes\n"
                "workoutItems: ${workoutItems[2]}\n" +
                "duration: $duration\n"
    }
}

sealed class WorkoutItem {
    data class ExerciseItem(val exercise: Exercise) : WorkoutItem()
    data class SupersetItem(val superset: Superset) : WorkoutItem()
}