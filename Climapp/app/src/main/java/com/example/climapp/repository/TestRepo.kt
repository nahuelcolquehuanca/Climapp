package com.example.climapp.repository

import com.example.climapp.repository.models.City
import com.example.climapp.repository.models.Weather


//class TestRepo: Repository {
//
//    override suspend fun searchCity(city: String): List<City> {
//        val city1= City(name = "CABA", lat = -23.0, lon = -23.0, country = "AR", state = "Argentina")
//        val city2= City(name = "Cordoba", lat = -33.0, lon = -33.0, country = "AR", state = "Argentina")
//        val city3= City(name = "Neuquen", lat = -43.0, lon = -43.0, country = "AR", state = "Argentina")
//        return listOf(city1, city2, city3)
//    }
//
//    override suspend fun getWeather(city: City): Weather {
//        val weather1 = WeatherShort(temperature = 10, humidity = 30.0f, city = "CABA", st = 12, wind = 20, lat = -31, lon=-32, state = "Argentina")
//        val weather2 = WeatherShort(temperature = 12, humidity = 10.0f, city = "CABA", st = 14, wind = 30, lat = -31, lon=-32, state = "Argentina")
//        val example = Weather()
//        return;
//    }
//
//    override suspend fun getForectast(city: City): List<Weather> {
//        TODO("Not yet implemented")
//    }
//}