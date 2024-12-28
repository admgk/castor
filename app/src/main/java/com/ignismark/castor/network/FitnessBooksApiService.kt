package com.ignismark.castor.network

import com.ignismark.castor.data.Book
import retrofit2.http.GET

interface FitnessBooksApiService {
    @GET("volumes?q=dumbbell+workout")
    suspend fun getFitnessBooks(): List<Book>
}