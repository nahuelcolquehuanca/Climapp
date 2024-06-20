package com.example.climapp.weather

sealed class WeatherIntention {
    data class GetWeather(
        val lat: String,
        val lon: String
    ) : WeatherIntention()
    data object Blank : WeatherIntention()
}