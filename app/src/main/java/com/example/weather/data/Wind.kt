package com.example.weather.data

import com.google.gson.annotations.SerializedName


data class Wind(
    @SerializedName("speed") val speed :String?,
)
