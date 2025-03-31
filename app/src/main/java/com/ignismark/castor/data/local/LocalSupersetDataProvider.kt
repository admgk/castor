package com.ignismark.castor.data.local

import com.ignismark.castor.model.Superset
import kotlin.time.Duration

object LocalSupersetDataProvider {
    val superset: Superset = Superset(
        exercises = listOf(
            LocalExercisesDataProvider.exercises[2],
            LocalExercisesDataProvider.exercises[3]
        ),
        name = "SUPERSET",
        interSetRest = Duration.parse("PT1M")
    )
}