package com.ignismark.castor.model

data class Exercise(
    val name: String,
    val equipment: String, //TODO: enum
    val countType: CountType,
    val muscleGroup: String //TODO: enum
)
