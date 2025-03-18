package com.ignismark.castor.model

class RepsAndWeight(val reps: Int?, val weight: Double?) : CountType {
    override val name: String = "Reps and Weight"

    override fun toString(): String {
        return name
    }
}