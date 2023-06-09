package com.example.weather.ui

import com.example.weather.data.Weather
import com.example.weather.network.ApiServiceImpl

class WeatherPresenter(private val view: IWeather) {

    private val service = ApiServiceImpl()


    fun getWeather(cityName: String) {
        service.getWeather(cityName, ::onSuccess, ::onFailure)
    }

    private fun onSuccess(response: Weather) {
        view.onWeatherSuccess(response)

    }

    private fun onFailure(message: String?) {
        view.onWeatherFailure(message.toString())
    }


}