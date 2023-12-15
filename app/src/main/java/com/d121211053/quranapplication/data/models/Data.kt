package com.d121211053.quranapplication.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Data(
    @SerialName("available")
    val available: Int,
    @SerialName("hadith")
    val hadiths: List<Hadith> = emptyList(),
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("requested")
    val requested: Int
): Parcelable