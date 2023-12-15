package com.d121211053.quranapplication.data.source.remote

import com.d121211053.quranapplication.data.response.GetHadithResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/books/muslim")
    suspend fun getHadith(
        @Query("range") range: String
    ): GetHadithResponse
}