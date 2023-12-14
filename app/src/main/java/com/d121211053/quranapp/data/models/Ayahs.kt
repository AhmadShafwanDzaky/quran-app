package com.d121211053.quranapp.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Ayahs(
    @SerialName("number")
    val number: Int?,
    @SerialName("text")
    val text: String?,
    @SerialName("numberInSurah")
    val numberInSurah: Int?,
    @SerialName("juz")
    val juz: Int?,
    @SerialName("manzil")
    val manzil: Int?,
    @SerialName("page")
    val page: Int?,
    @SerialName("ruku")
    val ruku: Int?,
    @SerialName("hizbQuarter")
    val hizbQuarter: Int?,
    @SerialName("sajda")
    val sajda: Boolean?,
) : Parcelable