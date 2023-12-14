package com.d121211053.quranapp.data.source.remote

import com.d121211053.quranapp.data.models.Surah
import com.d121211053.quranapp.data.models.Surahs
import com.d121211053.quranapp.data.response.GetResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("v1/surah")
    suspend fun getSurah(): GetResponse<List<Surah>>
    @GET("v1/surah/{surah}/{edition}")
    suspend fun getSurahDetail(
        @Path("surah") surah: Int,
        @Path("edition") edition: String):GetResponse<Surahs>
}