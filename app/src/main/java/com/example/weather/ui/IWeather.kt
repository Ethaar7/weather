package com.example.weather.ui

interface IView

interface IWeather: IView {
    fun showLoading()
    fun hideLoading()
    fun onWeatherSuccess()
    fun onWeatherFailure(error: String)
}