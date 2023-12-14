package com.d121211053.quranapp.data.repository

import com.d121211053.quranapp.data.models.Surah
import com.d121211053.quranapp.data.models.Surahs
import com.d121211053.quranapp.data.source.remote.ApiService
import com.d121211053.quranapp.data.response.GetResponse

class Repository(private val apiService: ApiService) {
    suspend fun getSurah(): GetResponse<List<Surah>> {
        return apiService.getSurah()
    }
    suspend fun getSurahDetail(surah: Int, edition: String): GetResponse<Surahs> {
        return apiService.getSurahDetail(surah , edition)
    }
}