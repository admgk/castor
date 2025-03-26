package com.ignismark.castor.model

import kotlin.time.Duration

data class Set(
    val attempts: List<Attempt>,
    val rest: Duration
)
