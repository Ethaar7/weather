package com.example.weather.data


import com.google.gson.annotations.SerializedName



data class Main(
    @SerializedName("temp")
    val temp: String?,
    @SerializedName("humidity")
    val humidity: String?,

)
