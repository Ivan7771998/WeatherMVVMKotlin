package com.example.weathermvvmkotlin.data.db

import android.content.Context
import androidx.room.*
import com.example.weathermvvmkotlin.data.db.entity.CurrentWeatherEntry
import com.example.weathermvvmkotlin.internal.StringListConverter

@Database(
    entities = [CurrentWeatherEntry::class],
    version = 1
)
@TypeConverters(StringListConverter::class)
abstract class ForecastDatabase : RoomDatabase() {
    abstract fun currentWeatherDao(): CurrentWeatherDao

    companion object {
        @Volatile
        private var instance: ForecastDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ForecastDatabase::class.java, "forecast.db"
            ).build()

    }
}