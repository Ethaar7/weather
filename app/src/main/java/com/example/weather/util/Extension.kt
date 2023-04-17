package com.example.weather.util

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String) {
    Glide
        .with(context)
        .load(url)
        .centerCrop()
        .into(this)
}

fun kelvinToCelsius(kelvin: Double): Double {
    return kelvin - 273.15
}

fun metersPerSecondToKilometersPerHour(mps: Double): Double {
    return mps * 3.6
}


fun getIcon() {
    mapOf(
        "01d" to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/01d.png",
        "01n" to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/01n.png",
        "02d" to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/02d.png",
        "02n" to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/02n.png",
        "03d" to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/03d.png",
        "03n" to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/03n.png",
        "04d" to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/04d.png",
        "04n" to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/04n.png",
        "09d" to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/09d.png",
        "09n" to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/09n.png",
        "10d" to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/10d.png",
        "10n" to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/10n.png",
        "11d" to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/11d.png",
        "11n" to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/11n.png",
        "13d" to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/13d.png",
        "50d" to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/50d.png",
        "50n" to "https://raw.githubusercontent.com/mustafa-sab3alarab/The-Chance-Plus-Docs/main/weather_icon/50n.png"
    )
}


//    binding.image.loadImage(getIcon()[weather.weatherdata.Icon])

