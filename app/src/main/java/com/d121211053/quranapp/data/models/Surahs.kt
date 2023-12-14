package com.d121211053.quranapp.data.models

import com.d121211053.quranapp.data.models.Ayahs
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Surahs(
    @SerialName("number")
    val number: Int?,
    @SerialName("name")
    val name: String?,
    @SerialName("englishName")
    val englishName: String?,
    @SerialName("englishNameTranslation")
    val englishNameTranslation: String?,
    @SerialName("revelationType")
    val revelationType: String?,
    @SerialName("numberOfAyahs")
    val numberOfAyahs: Int?,
    @SerialName("ayahs")
    val ayahs: List<Ayahs>?,
) : Parcelable