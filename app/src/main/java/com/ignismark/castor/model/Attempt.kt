package com.ignismark.castor.model

import kotlin.time.Duration

data class Attempt(
    val exercise: Exercise,
    val reps: Double?,
    val weight: Double?,
    val time: Duration?,
    val distance: Double?
)