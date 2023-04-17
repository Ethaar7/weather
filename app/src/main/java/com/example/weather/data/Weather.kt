package com.example.weather.data

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("weather")
    val weather:ArrayList<WeatherData>?,
    @SerializedName("main")
    val main : Main?,
    @SerializedName("wind")
    val wind:Wind?,
    @SerializedName("rain")
    val rain:Rain?,
    @SerializedName("name")
    val name : String?,
    @SerializedName("cod")
    val cod:String?,
    @SerializedName("sys")
    val sys:Sys?


)

