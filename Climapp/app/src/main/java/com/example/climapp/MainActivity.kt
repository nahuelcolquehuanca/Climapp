package com.example.climapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.climapp.MainPage
import com.example.climapp.search.SearchIntention
import com.example.climapp.search.SearchPage
import com.example.climapp.ui.theme.ClimappTheme
import com.example.climapp.weather.WeatherPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClimappTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SearchPage(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

