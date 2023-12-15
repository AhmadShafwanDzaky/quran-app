package com.d121211053.quranapplication.data.response

import android.os.Parcelable
import com.d121211053.quranapplication.data.models.Data
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class GetHadithResponse(
    @SerialName("code")
    val code: Int,
    @SerialName("data")
    val `data`: Data,
    @SerialName("error")
    val error: Boolean,
    @SerialName("message")
    val message: String
) : Parcelable