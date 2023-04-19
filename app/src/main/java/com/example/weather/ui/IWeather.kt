package com.example.weather.ui

import com.example.weather.data.Weather


interface IWeather {

    fun onWeatherSuccess(weather:Weather)
    fun onWeatherFailure(error: String)
}