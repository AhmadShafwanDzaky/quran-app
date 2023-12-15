package com.d121211053.quranapplication.data

import com.d121211053.quranapplication.data.repository.HadithRepository
import com.d121211053.quranapplication.data.source.remote.ApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface HadithAppContainer {
    val hadithRepository: HadithRepository
}

class DefaultHadithAppContainer: HadithAppContainer {
    private val BASE_URL = "https://api.hadith.gading.dev"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val hadithRepository: HadithRepository
        get() = HadithRepository(retrofitService)
}