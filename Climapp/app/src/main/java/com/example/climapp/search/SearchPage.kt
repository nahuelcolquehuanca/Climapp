package com.example.climapp.search

import android.app.appsearch.SearchResults
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.climapp.repository.models.City
import com.example.climapp.ui.theme.ClimappTheme
import java.lang.Exception

@Composable
fun SearchPage(modifier: Modifier = Modifier,
               //cities: List<City>
                )
{
    //se le indica con que factory construir el viewModel--- ver SearchViewModel.kt
    val viewModel: SearchViewModel = viewModel(factory = SearchViewModel.factory)
    SearchView(modifier = modifier, state = viewModel.uiState) {
        viewModel.execute(it)
    }

}

@Composable
fun SearchView(modifier: Modifier, state: SearchState, execute: (SearchIntention)->Unit){
    Column(modifier = modifier.fillMaxSize()) {
        var toSearch by remember {
            mutableStateOf("")
        }

        TextField(value = toSearch, onValueChange = {
            toSearch = it
        })
        Button(onClick = {
            execute(SearchIntention.Search(toSearch))
        }) {
            Text(text = "Buscar")
        }
        Column(modifier = modifier.padding(30.dp)) {
            when(state){
                is SearchState.Empty-> SearchResultsEmpty()
                is SearchState.Loading ->SearchResultsLoading()
                is SearchState.Error ->SearchResultsError(state.error)
                is SearchState.Success-> SearchResultsSuccess(cities=state.cities, modifier= modifier)
            }
        }
    }
}

@Composable
fun SearchResultsEmpty(){
    Text(text = "Sin resultados")
}

@Composable
fun SearchResultsLoading(){
    Text(text = "Cargando")
}

@Composable
fun SearchResultsError(error:String){
    Text(text = error)
}

@Composable
fun SearchResultsSuccess(cities: List<City>, modifier: Modifier){
    Text(text = "Resultados:")
    LazyColumn(modifier = modifier) {
        items(items = cities){
            Card {
                Text(text = it.name)
                Text(text = it.country)
                Text(text = it.lat.toString())
                Text(text = it.lon.toString())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchPagePreview(){
    val cities = remember {
        mutableStateListOf<City>()
    }
    ClimappTheme {
        SearchView(modifier = Modifier, state = SearchState.Loading) {
            
        }
    }
}