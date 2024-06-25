package com.example.climapp.weather

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.climapp.repository.RepoAPI
//import com.example.climapp.repository.TestRepo
import com.example.climapp.repository.Repository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.launch

class WeatherViewModel(val repository: Repository): ViewModel() {
    companion object{
        val factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
            //elejimos que repositorio usar
            val repository = RepoAPI()
            WeatherViewModel(repository)
        } }
    }
    var uiState by mutableStateOf<WeatherState>(WeatherState.Loading)
    val client = HttpClient(){
        install(ContentNegotiation){
            json(kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
            })
        }
    }
    val urlGetWeather: String = "https://api.openweathermap.org/data/2.5/weather"
    val urlGetCities: String = "http://api.openweathermap.org/geo/1.0/direct"
    val urlGetForecast: String = "http://api.openweathermap.org/data/2.5/forecast"

    fun execute (intention: WeatherIntention){
        when(intention){
            is WeatherIntention.GetWeather -> update(lat=intention.lat, lon = intention.lon)
            WeatherIntention.Blank -> blank()
        }
    }

    private fun update(lat: String, lon: String) {
        uiState = WeatherState.Loading
        viewModelScope.launch {
            try {
                val result = repository.getWeather(lat = lat, lon = lon)
                val forecast = repository.getForectast(lat = lat, lon = lon)
                uiState = WeatherState.Success(
                    temperature = result.main.temp.toInt(),
                    city = result.name,
                    st = result.main.feels_like.toInt(),
                    state = result.weather.first().description,
                    forecast = forecast
                )
            }catch (exception:Exception){
                uiState = WeatherState.Error(exception.message?:"Contacte a Soporte")
            }
        }
    }

    private fun blank(){

    }

}