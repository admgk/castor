package com.ignismark.castor.data

import android.content.Context
import com.ignismark.castor.data.database.OfflineWorkoutsRepository
import com.ignismark.castor.data.database.WorkoutDatabase
import com.ignismark.castor.data.database.WorkoutsRepository
import com.ignismark.castor.network.FitnessBooksApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val fitnessBooksRepository: FitnessBooksRepository
    val workoutsRepository: WorkoutsRepository
}

class DefaultAppContainer(private val context: Context) : AppContainer {
    private val BASE_URL = "https://www.googleapis.com/books/v1/"

    private val json = Json { ignoreUnknownKeys = true }

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: FitnessBooksApiService by lazy {
        retrofit.create(FitnessBooksApiService::class.java)
    }

    override val fitnessBooksRepository: FitnessBooksRepository by lazy {
        DefaultFitnessBooksRepository(retrofitService)
    }

    override val workoutsRepository: WorkoutsRepository by lazy {
        OfflineWorkoutsRepository(WorkoutDatabase.getDatabase(context).workoutDao())
    }
}