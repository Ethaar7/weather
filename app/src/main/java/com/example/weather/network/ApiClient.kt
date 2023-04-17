package com.example.weather.network

import com.example.weather.BuildConfig
import okhttp3.*

class ApiClient {

    private val client2 = OkHttpClient()


    fun makeRequest(cityName: String) : Call {

        val request = Request.Builder()
            .url(httpUrl(cityName))
            .build()
       return client2.newCall(request)
    }


    private fun httpUrl(cityName: String): HttpUrl {
        return HttpUrl.Builder()
            .scheme(SCHEME)
            .host(BuildConfig.HOST)
            .addPathSegment(DATA)
            .addPathSegment(VERSION)
            .addPathSegment(WEATHER)
            .addQueryParameter(API_ID2, BuildConfig.API_ID)
            .build()

    }


    private companion object {
        const val SCHEME = "https"
        const val DATA = "data"
        const val VERSION = "2.5"
        const val WEATHER = "weather"
        const val API_ID2 = "appid"
    }


}

