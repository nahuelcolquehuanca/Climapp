package com.example.climapp.search

sealed class SearchIntention {
    data class Search(val city: String): SearchIntention()
    data object Delete: SearchIntention()
}