package com.example.climapp.repository

import com.example.climapp.repository.models.City
import com.example.climapp.repository.models.Weather

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.HttpStatusCode
import io.ktor.http.parametersOf
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class RepoAPI: Repository {

    private val apiKey = "d2e6eaf9217b3aeb5be5f2957d6e0300"
    private val units = "metric"

    private val client = HttpClient(){
        install(ContentNegotiation){
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }
    override suspend fun searchCity(city: String): List<City> {
        val response = client.get("http://api.openweathermap.org/geo/1.0/direct"){
            parameter("q", city)
            parameter("limit", 5)
            parameter("appid", apiKey)
        }
        if(response.status == HttpStatusCode.OK)
        {
            val cities= response.body<List<City>>()
            return cities
        }else{
            throw Exception()
        }
    }

    override suspend fun getWeather(lat: String, lon: String): Weather {
            val response = client.get("https://api.openweathermap.org/data/2.5/weather"){
                parameter("lat", lat)
                parameter("lon", lon)
                parameter("units",units)
                parameter("appid", apiKey)
            }
            if(response.status == HttpStatusCode.OK){
                val weather = response.body<Weather>()
                return weather
            }else{
                throw Exception()
            }

    }

    override suspend fun getForectast(city: City): List<Weather> {
        TODO("Not yet implemented")
    }
}