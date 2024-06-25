package com.example.climapp.weather


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.climapp.ui.theme.ClimappTheme


@Composable
fun WeatherPage(modifier: Modifier = Modifier, lat: Double, lon: Double){
    var viewModel: WeatherViewModel = viewModel(factory = WeatherViewModel.factory)
    WeatherView(modifier = modifier, latGPS = lat, lonGPS = lon, state = viewModel.uiState){
        viewModel.execute(it)
    }
}

@Composable
fun WeatherView(modifier: Modifier, state: WeatherState,  latGPS: Double, lonGPS: Double, execute: (WeatherIntention)->Unit){
    Column(modifier= modifier.fillMaxSize()) {
        var lat by remember {
            mutableStateOf("")
        }
        var lon by remember {
            mutableStateOf("")
        }
//        TextField(modifier = modifier,
//            value = lat,
//            onValueChange = { lat = it },
//            label = {
//                Text(text = "Ingrese Latitud")
//            })
//        TextField(modifier = modifier,
//            value = lon,
//            onValueChange = {
//            lon = it
//        }, label = { Text(text = "Ingrese Longitud")})
        Row(modifier = modifier) {

            Button(onClick = { execute(WeatherIntention.GetWeather(lat, lon)) }) {
                Text(text = "Obtener Clima")
            }
            Button(onClick = { execute(WeatherIntention.GetWeather(latGPS.toString(), lonGPS.toString())) }) {
                Text(text = "Usar ubicación actual" )
            }
        }
        Card(modifier = modifier) {
            when(state){
                is WeatherState.Success -> WeatherViewSuccess(state, modifier = modifier)
                is WeatherState.Loading -> WeatherViewLoading()
                is WeatherState.Error -> WeatherViewError(state)
                WeatherState.Blank -> WeatherViewBlank()
            }
        }
    }
}

@Composable
fun WeatherViewSuccess(state: WeatherState.Success, modifier: Modifier){
    val sdf = java.text.SimpleDateFormat("EEE, MMM d, HH:mm")
    var count: Int = 3

    Column(modifier = Modifier) {
        Text(text = "Temperatura: ${state.temperature}")
        Text(text = "Sensacion termica: ${state.st}")
        Text(text = "Ciudad: "+state.city)
        Text(text = "Estado: "+state.state)
        Spacer(modifier = modifier)
        Text(text = "Pronostico: ")
        Card(modifier = modifier.fillMaxSize().padding(2.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiary)) {
            LazyColumn(modifier = modifier) {
                items(items = state.forecast){
                    count++
                    val date = java.util.Date(it.dt *1000)
                    sdf.format(date)
                    Card {
                        Text(text = "${date}")
                        Text(text = "Temperatura Max: ${it.main.temp_max}")
                        Text(text = "Temperatura Min: ${it.main.temp_min}")
                    }

                }
            }
        }
    }

}

@Composable
fun WeatherViewLoading(){
    Text(text = "Cargando")

}

@Composable
fun WeatherViewError(state: WeatherState.Error){
    Text(text = "Error: "+ state.message)
}

@Composable
fun WeatherViewBlank(){
    Text(text = "")
}



@Preview(showBackground = true)
@Composable
fun WeatherPagePreview(){
    ClimappTheme {
        WeatherView(state = WeatherState.Loading, modifier = Modifier, latGPS = 1.0, lonGPS = 0.2, execute = {})
    }
}
