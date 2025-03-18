package com.ignismark.castor.model

import kotlin.time.Duration

data class Set(
    val rest: Duration,
    val attempts: List<Attempt>
)
