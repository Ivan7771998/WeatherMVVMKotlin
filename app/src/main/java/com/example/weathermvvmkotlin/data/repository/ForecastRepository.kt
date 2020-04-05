package com.example.weathermvvmkotlin.data.repository

import androidx.lifecycle.LiveData
import com.example.weathermvvmkotlin.data.db.initlocalized.UnitSpecificCurrentWeatherEntry

interface ForecastRepository {
    suspend fun getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>
}