package com.d121211053.quranapp.data.response

import com.d121211053.quranapp.data.models.Surah
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetResponse<Code>(
    @SerialName("code")
    val code: Code?,
    @SerialName("status")
    val status: String?,
    @SerialName("data")
    val data: Int?
)
