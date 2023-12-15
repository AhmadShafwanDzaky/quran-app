package com.d121211053.quranapplication.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Hadith(
    @SerialName("arab")
    val arab: String,
    @SerialName("id")
    val id: String,
    @SerialName("number")
    val number: Int
) : Parcelable