package com.example.weathermvvmkotlin.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weathermvvmkotlin.data.db.entity.CURRENT_WEATHER_ID
import com.example.weathermvvmkotlin.data.db.entity.CurrentWeatherEntry
import com.example.weathermvvmkotlin.data.db.initlocalized.ImperialCurrentWeatherEntry

@Dao
interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(weatherEntry: CurrentWeatherEntry)

    @Query("select * from current_weather where id= $CURRENT_WEATHER_ID")
    fun getWeather(): LiveData<ImperialCurrentWeatherEntry>

}