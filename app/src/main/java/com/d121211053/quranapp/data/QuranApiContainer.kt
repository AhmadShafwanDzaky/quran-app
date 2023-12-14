package com.d121211053.quranapp.data

import com.d121211053.quranapp.data.repository.Repository
import com.d121211053.quranapp.data.source.remote.ApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface QuranApiContainer {
    val quranRepository: Repository
}

class DefaultQuranApiContainer: QuranApiContainer {

    private val BASE_URL = "https://api.alquran.cloud"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val quranRepository: Repository
        get() = Repository(retrofitService)

}