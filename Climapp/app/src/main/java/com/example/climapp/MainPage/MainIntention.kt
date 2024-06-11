package com.example.climapp.MainPage

sealed class MainIntention {
    data object Update :MainIntention()
    data object Search : MainIntention()

}