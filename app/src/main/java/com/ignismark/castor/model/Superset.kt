package com.ignismark.castor.model

import kotlin.time.Duration

data class Superset(
    val supersetId: String,
    val exercises: List<Exercise>,
    val name: String? = null, // Optional name for the superset
    val notes: String? = null,
    val interSetRest: Duration? = null
)