package com.ignismark.castor.model

import kotlin.time.Duration

class TimeAndWeight(val time: Duration?, val weight: Double?) : CountType {
    override val name: String = "Time and Weight"

    override fun toString(): String {
        return name
    }
}