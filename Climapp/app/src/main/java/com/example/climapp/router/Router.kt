package com.example.climapp.router

import androidx.navigation.NavHostController

class Router(val navigationController: NavHostController){
    fun navigateTo(ruta: Ruta){
        navigationController.navigate(ruta.id)
    }
}


