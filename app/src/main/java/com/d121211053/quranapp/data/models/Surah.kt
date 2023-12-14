package com.d121211053.quranapp.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Surah(
    @SerialName("number")
    val number: Int?,
    @SerialName("name")
    val name: String?,
    @SerialName("englishName")
    val englishName: String?,
    @SerialName("englishNameTranslation")
    val englishNameTranslation: String?,
    @SerialName("numberOfAyahs")
    val numberOfAyahs: Int?,
    @SerialName("revelationType")
    val revelationType: String?,
) : Parcelable