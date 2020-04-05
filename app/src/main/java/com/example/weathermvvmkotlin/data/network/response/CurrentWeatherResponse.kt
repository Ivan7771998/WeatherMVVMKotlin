package com.example.weathermvvmkotlin.data.network.response

import com.example.weathermvvmkotlin.data.db.entity.CurrentWeatherEntry
import com.example.weathermvvmkotlin.data.db.entity.Location
import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    val location: Location
)