package com.example.climapp.MainPage

sealed class MainState{
    data object Success: MainState()
    data object Loading: MainState()
    data object Error: MainState()

}