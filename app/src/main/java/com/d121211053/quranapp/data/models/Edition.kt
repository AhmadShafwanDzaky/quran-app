package com.d121211053.quranapp.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Edition(
    @SerialName("identifier")
    val identifier: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("englishName")
    val englishName: String?,
    @SerialName("language")
    val language: String?,
    @SerialName("format")
    val format: String?,
    @SerialName("type")
    val type: String?,
    @SerialName("direction")
    val direction: String?,
) : Parcelable