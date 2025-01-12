package com.ignismark.castor.data

import com.ignismark.castor.network.FitnessBooksApiService

interface FitnessBooksRepository {
    suspend fun getFitnessBooks(): NestedJsonModel
}

class DefaultFitnessBooksRepository(
    private val fitnessBooksApiService: FitnessBooksApiService
) : FitnessBooksRepository {
    override suspend fun getFitnessBooks(): NestedJsonModel = fitnessBooksApiService.getFitnessBookData()
}