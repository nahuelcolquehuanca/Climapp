package com.example.climapp.repository.models

import kotlinx.serialization.Serializable

@Serializable
data class Weather(
    val base: String,
    val name: String,
    val coord: Coord,
    val weather: List<WeatherRoot>,
    val main: Main,
    val wind: Wind,
    val clouds: Clouds,
)
@Serializable
data class Coord(
    val lon: Double,
    val lat: Double,
)
@Serializable
data class WeatherRoot(
    val id: Long,
    val main: String,
    val description: String,
    val icon: String,
)
@Serializable
data class Main(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Long,
    val humidity: Long,
)
@Serializable
data class Wind(
    val speed: Double,
    val deg: Long,
    val gust: Double? = null,
)

@Serializable
data class Clouds(
    val all: Long,
)