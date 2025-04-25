package com.ignismark.castor.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.time.LocalDate
import kotlin.time.Duration

@Entity(tableName = "workouts")
data class Workout(
    @PrimaryKey
    val workoutId: String,
    val dateString: String,
    val name: String = "WORKOUT",
    val notes: String? = null,
    val exercises: String,
    val durationString: String,
) {
    @Ignore
    val date: LocalDate = LocalDate.parse(dateString)

    @Ignore
    val duration: Duration = Duration.parse(durationString)

    override fun toString(): String {
        return "workoutId: $workoutId\n" +
                "date: $date\n" +
                "name: $name\n" +
                "notes: $notes\n"
                "workoutItems: ${exercises}\n" +
                "duration: $duration\n"
    }
}