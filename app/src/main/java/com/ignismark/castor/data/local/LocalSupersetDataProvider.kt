package com.ignismark.castor.data.local

import com.ignismark.castor.model.Superset
import java.util.UUID
import kotlin.time.Duration

object LocalSupersetDataProvider {
    val superset: Superset = Superset(
        supersetId = UUID.randomUUID().toString(),
        exercises = listOf(
            LocalExercisesDataProvider.exercises[2],
            LocalExercisesDataProvider.exercises[3]
        ),
        name = "SUPERSET",
        interSetRest = Duration.parse("PT1M")
    )
}