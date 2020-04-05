package com.example.weathermvvmkotlin.data.db.initlocalized

interface UnitSpecificCurrentWeatherEntry {
    val temperature: Double
    val winSpeed:Double
    val windDirection: String
    val precipitationVolume: Double
    val feelsLikeTemperature: Double
    val visibilityDistance: Double
}