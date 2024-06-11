package com.example.climapp.SearchPage

sealed class SearchState {
    data object Success : SearchState()
    data object Searching: SearchState()
    data object NotFound: SearchState()
    data object Error: SearchState()
}