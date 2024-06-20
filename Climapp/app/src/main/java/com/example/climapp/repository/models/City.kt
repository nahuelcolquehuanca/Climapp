package com.example.climapp.repository.models

import kotlinx.serialization.Serializable

@Serializable
data class City (
    val name: String,
    //val localNames: List<String>,
    val lat: Double,
    val lon: Double,
    val country: String,
    val state: String,
)
