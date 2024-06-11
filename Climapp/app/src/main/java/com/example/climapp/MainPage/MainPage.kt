package com.example.climapp.MainPage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.climapp.ui.theme.ClimappTheme

@Composable
fun MainPage(modifier: Modifier = Modifier) {
    MainView(modifier = modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(modifier: Modifier){
    Column(modifier = modifier
        .fillMaxSize()
        .padding(20.dp)) {
        Row {
            TextField(value = "Ingrese Ciudad", onValueChange ={})
            Card(modifier = modifier
                .weight(0.20f)
                .padding(10.dp)) {
                Text(text = "Loc")
            }
        }
        Card(modifier= modifier
            .align(Alignment.CenterHorizontally)
            .weight(0.60f)
            .fillMaxWidth()
            .padding(10.dp)) {

            Row {
                Text(text = "CABA")
            }
            Text(text = "23", style = MaterialTheme.typography.displayLarge)
        }
        Card(modifier= modifier
            .align(Alignment.CenterHorizontally)
            .weight(0.40f)
            .fillMaxWidth()
            .padding(10.dp)){
            Text(text = "Detalles")
        }
        Card(modifier= modifier
            .align(Alignment.CenterHorizontally)
            .weight(0.30f)
            .fillMaxWidth()
            .padding(10.dp)) {
            Text(text = "Pronostico 7 dias")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    ClimappTheme {
        MainPage()
    }
}