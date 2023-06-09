package com.example.weather.data

import com.google.gson.annotations.SerializedName



data class WeatherData(
    @SerializedName("id") val id : String?,
    @SerializedName("main") val main : String?,
    @SerializedName("icon") val icon : String?,
)
