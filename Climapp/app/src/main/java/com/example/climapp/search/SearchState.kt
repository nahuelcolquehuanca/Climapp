package com.example.climapp.search

import com.example.climapp.repository.models.City

sealed class SearchState {
    data class Success(val cities: List<City>): SearchState()
    data class Error(val error: String): SearchState()
    data object Loading: SearchState()
    data object Empty: SearchState()
}