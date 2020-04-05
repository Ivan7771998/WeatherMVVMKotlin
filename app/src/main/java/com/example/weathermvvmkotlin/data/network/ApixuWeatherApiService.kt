package com.example.weathermvvmkotlin.data.network

import com.example.weathermvvmkotlin.data.network.response.CurrentWeatherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "0794eb110d9073d27788c0128ae66803"

//http://api.weatherstack.com/current?access_key=0794eb110d9073d27788c0128ae66803&query=New%20York

interface ApixuWeatherApiService {
    @GET("current?")
    fun getCurrentWeatherAsync(
        @Query("query") location: String,
        @Query("language ") languageCode: String = "rus"
    ): Deferred<CurrentWeatherResponse>

    companion object {
        operator fun invoke(
            connectivityInterceptor: ConnectivityInterceptor
        ): ApixuWeatherApiService {
            val requestInterceptor = Interceptor { chain ->
                val url =
                    chain.request()
                        .url()
                        .newBuilder()
                        .addQueryParameter("access_key",
                            API_KEY
                        )
                        .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url).build()
                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(connectivityInterceptor)
                .build()
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://api.weatherstack.com/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApixuWeatherApiService::class.java)

        }
    }

}