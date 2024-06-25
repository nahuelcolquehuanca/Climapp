package com.example.climapp.repository

import com.example.climapp.repository.models.City
import com.example.climapp.repository.models.ListForecast
import com.example.climapp.repository.models.Weather


interface Repository {
    suspend fun searchCity(city: String): List<City>
    suspend fun getWeather(lat: String, lon: String): Weather
    suspend fun getForectast(lat: String, lon: String): List<ListForecast>
}