package com.example.weathermvvmkotlin.ui.weather.current

import androidx.lifecycle.ViewModel
import com.example.weathermvvmkotlin.data.repository.ForecastRepository
import com.example.weathermvvmkotlin.internal.UnitSystem
import com.example.weathermvvmkotlin.internal.lazyDeferred

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository
) : ViewModel() {

    private val unitSystem = UnitSystem.METRIC

    private val isMetric: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather(isMetric)
    }
}
