package com.example.weather.network

import com.example.weather.data.Weather

interface ApiService {

    fun getWeather(
        cityName:String,
        onSuccess: (response:Weather) -> Unit,
        onFailure: (message: String?) -> Unit,
    )
}