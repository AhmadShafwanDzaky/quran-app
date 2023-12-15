package com.d121211053.quranapplication.data.repository

import com.d121211053.quranapplication.data.response.GetHadithResponse
import com.d121211053.quranapplication.data.source.remote.ApiService

class HadithRepository(private val apiService: ApiService) {

    suspend fun getHadith(range: String): GetHadithResponse {
        return apiService.getHadith(range)
    }

}