package com.example.climapp.repository.models

import kotlinx.serialization.Serializable

@Serializable
data class City (
    val name: String = "",
    //val localNames: List<String>,
    val lat: Double = 0.0,
    val lon: Double = 0.0,
    val country: String="",
    val state: String="",
)
