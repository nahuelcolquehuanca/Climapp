package com.example.climapp.MainPage

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainPageViewModel : ViewModel(){
    var uiState by mutableStateOf<MainState>(MainState.Loading)

    //fun getInfo(intencion: Main){

    //}
}