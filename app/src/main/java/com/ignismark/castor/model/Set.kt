package com.ignismark.castor.model

data class Set(
    val setId: String,
    val exerciseId: String,
    val reps: Int? = null, // Nullable: not used for all exercises
    val weight: Double? = null, // Nullable: not used for all exercises
    val duration: Long? = null, // Nullable: time-based exercises
    val distance: Double? = null // Nullable: distance-based exercises
)
