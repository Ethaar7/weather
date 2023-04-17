package com.example.weather.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weather.R
import com.example.weather.databinding.ActivityMainBinding
import okhttp3.OkHttpClient

class MainActivity : AppCompatActivity() , IWeather {

    private  lateinit var binding: ActivityMainBinding
    private val client= OkHttpClient()
    private lateinit var presenter:WeatherPresenter

    override fun onCreate(savedInstanceState: Bundle?) {

        binding= ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun hideLoading() {
        TODO("Not yet implemented")
    }

    override fun onWeatherSuccess() {
        TODO("Not yet implemented")
    }

    override fun onWeatherFailure(error: String) {
        TODO("Not yet implemented")
    }
}