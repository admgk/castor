package com.ignismark.castor.data

import com.ignismark.castor.network.FitnessBooksApiService

interface FitnessBooksRepository {
    suspend fun getFitnessBooks(): List<Book>
}

class DefaultFitnessBooksRepository(
    private val fitnessBooksApiService: FitnessBooksApiService
) : FitnessBooksRepository {
    override suspend fun getFitnessBooks(): List<Book> = fitnessBooksApiService.getFitnessBooks()
}