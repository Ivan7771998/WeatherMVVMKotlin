package com.example.weathermvvmkotlin.data.network

import androidx.lifecycle.LiveData
import com.example.weathermvvmkotlin.data.network.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {
    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String,
        languagesCode: String
    )
}