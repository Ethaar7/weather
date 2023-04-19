package com.example.weather.data


import com.google.gson.annotations.SerializedName



data class Rain(
    @SerializedName("1h") val oneHour:String?="0"
)
