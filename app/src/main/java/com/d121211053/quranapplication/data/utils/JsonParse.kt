package com.d121211053.quranapplication.data.utils

import com.d121211053.quranapplication.data.response.GetHadithResponse
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.*


// Your JSON parsing function
fun parseJson(jsonString: String) {
    val json = Json { ignoreUnknownKeys = true } // Set ignoreUnknownKeys to true
    try {
        val yourData: GetHadithResponse = json.decodeFromString(jsonString)
        // Process your data here
    } catch (e: SerializationException) {
        // Handle the exception
        e.printStackTrace()
    }
}