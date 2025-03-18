package com.ignismark.castor.model

import kotlin.time.Duration

class TimeAndDistance(val time: Duration?, val distance: Double?) : CountType {
    override val name: String = "Time and Distance"

    override fun toString(): String {
        return name
    }
}