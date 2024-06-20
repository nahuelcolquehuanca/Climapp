package com.example.climapp.search

sealed class SearchState {
    data class Success(val city: String, val country: String): SearchState()
    data object Error: SearchState()
    data object Loading: SearchState()
    data object Empty: SearchState()
}