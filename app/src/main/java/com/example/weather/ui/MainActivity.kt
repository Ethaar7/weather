package com.example.weather.ui

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.weather.R
import com.example.weather.data.Weather
import com.example.weather.databinding.ActivityMainBinding
import com.example.weather.util.getIcon
import com.example.weather.util.kelvinToCelsius
import com.example.weather.util.loadImage
import com.example.weather.util.metersPerSecondToKilometersPerHour

class MainActivity : AppCompatActivity(), IWeather {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: WeatherPresenter
    private var sharedPreferences: SharedPreferences? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Log.d("test", R.drawable.photo.toString())
        sharedPreferences = getSharedPreferences(SHEREDNAME, Context.MODE_PRIVATE)
        init()
    }

    private fun init() {
        presenter = WeatherPresenter(this)
        presenter.getWeather("Maysan")
    }


    override fun onWeatherSuccess(weather: Weather) {
        this.runOnUiThread {
            if (weather.main?.temp != null) {
                var temp = weather.main?.temp.toString()
                temp = temp.kelvinToCelsius().toInt().toString()
                binding.degreeCelsius.text = "$tempْ C"
                weather.weather?.get(0)?.icon?.let { getWeatherIcon(it) }
                var cityName = weather.name.toString()
                binding.cityName.text = "$cityName"
                var wind = weather.wind?.speed.toString()
                wind = wind.metersPerSecondToKilometersPerHour().toInt().toString()
                binding.wind.text = "$wind km/h"
                var humidity = weather.main.humidity.toString()
                binding.humidity.text = "$humidity %"
                var rain = weather.rain?.oneHour.toString()
                binding.rain.text = "$rain %"
                binding.imageView.setImageDrawable(getciothing(temp.toInt())?.let {
                    ContextCompat.getDrawable(this,
                        it
                    )
                })
            }
        }

    }

    fun getciothing(temp: Int):Int? {
        val temperature = when (temp) {
            in TEMP_RANGE_COLD -> TEMP_RANGE_COLD
            in TEMP_RANGE_GOLDILOCKS -> TEMP_RANGE_GOLDILOCKS
            else -> TEMP_RANGE_HOT
        }
        val clothing = mapOf<IntRange, List<Int>>(
            TEMP_RANGE_COLD to listOf(R.drawable.photo_0, R.drawable.white, R.drawable.red_09),
            TEMP_RANGE_GOLDILOCKS to listOf(R.drawable.blak, R.drawable.nice,R.drawable.nice87),
            TEMP_RANGE_HOT to listOf(R.drawable.alywas, R.drawable.likeit,R.drawable.photo_best)
        )
        val listImage=sharedPreferences?.getInt(LISTIMAGE,0)
        if (listImage==null){
            val randomClothes = clothing.get(temperature)?.shuffled()?.first()
            randomClothes?.toInt()?.let { sharedPreferences?.edit()?.putInt(LISTIMAGE, it)?.apply() }
            return randomClothes
        }
       else{
            val newClothes = clothing.get(temperature)?.filter {
                it!=listImage
            }?.random()
            newClothes?.toInt()?.let { sharedPreferences?.edit()?.putInt(LISTIMAGE, it)?.apply() }
            return newClothes

        }
    }

    private fun getWeatherIcon(iconId: String) {
        binding.apply {
            getIcon()[iconId]?.let { binding.imageWeather.loadImage(it) }
        }
    }
    override fun onWeatherFailure(error: String) {

    }
    companion object {
        const val SHEREDNAME = "sharedPreferences"
        private val TEMP_RANGE_COLD = 0..20
        private val TEMP_RANGE_GOLDILOCKS = 20..30
        private val TEMP_RANGE_HOT = 30..60
        private val LISTIMAGE = "listImage"
    }
}