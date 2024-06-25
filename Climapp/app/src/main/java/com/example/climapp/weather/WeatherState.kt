package com.example.climapp.weather

import com.example.climapp.repository.models.ListForecast

sealed class WeatherState {
    data class Success(
        val temperature: Int,
        val st: Int,
        val city: String,
        val state: String,
        val forecast: List<ListForecast>
    ) : WeatherState()
    data class Error(val message: String) : WeatherState()
    data object Loading: WeatherState()
    data object Blank : WeatherState()
}