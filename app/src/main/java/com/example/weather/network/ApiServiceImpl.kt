package com.example.weather.network

import com.example.weather.data.Weather
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

class ApiServiceImpl : ApiService {

    private val client = ApiClient()

    override fun getWeather(
        cityName: String,
        onSuccess: (response: Weather) -> Unit,
        onFailure: (message: String?) -> Unit
    ) {
        client.makeRequest(cityName).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                onFailure(e.message.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                val gson = Gson()
                val responseWeather = gson.fromJson(response.body?.string(), Weather::class.java)
                onSuccess(responseWeather)
            }
        })

    }


}

