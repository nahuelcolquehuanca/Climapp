package com.example.climapp.router

sealed class Ruta(val id: String){
    data object SearchPage: Ruta("SearchPage")
    data object WeatherPage: Ruta("WeatherPage")
}