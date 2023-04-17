package com.example.weather.data


import com.google.gson.annotations.SerializedName



data class Main(
    @SerializedName("temp")
    val temp: String?,
    @SerializedName("feels_like")
    val feels_like: String?,
    @SerializedName("temp_min")
    val temp_min: String?,
    @SerializedName("temp_max")
    val temp_max: String?,
    @SerializedName("pressure")
    val pressure: String?,
    @SerializedName("humidity")
    val humidity: String?,
    @SerializedName("sea_level")
    val sea_level: String?,
    @SerializedName("grnd_level")
    val grnd_level: String?,
)
