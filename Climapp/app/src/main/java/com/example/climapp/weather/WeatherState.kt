package com.example.climapp.weather

sealed class WeatherState {
    data class Success(
        val temperature: Int,
        val st: Int,
        val city: String,
        val state: String
    ) : WeatherState()
    data class Error(val message: String) : WeatherState()
    data object Loading: WeatherState()
    data object Blank : WeatherState()
}