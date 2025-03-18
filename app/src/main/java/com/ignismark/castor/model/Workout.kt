package com.ignismark.castor.model

import java.time.LocalDate
import java.time.LocalTime
import kotlin.time.Duration

data class Workout(
    val date: LocalDate,
    val startTime: LocalTime,
    val endTime: LocalTime,
    val duration: Duration,
    val sets: List<Set>,
    val notes: String? = null
)
