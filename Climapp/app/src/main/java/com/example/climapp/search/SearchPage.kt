package com.example.climapp.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.climapp.ui.theme.ClimappTheme
import java.lang.Exception

@Composable
fun SearchPage(modifier: Modifier = Modifier){
    //se le indica con que factory construir el viewModel--- ver SearchViewModel.kt
    val viewModel: SearchViewModel = viewModel(factory = SearchViewModel.factory)
    SearchView(modifier = modifier, state = viewModel.uiState) {
        viewModel.execute(it)
    }

}

@Composable
fun SearchView(modifier: Modifier, state: SearchState, execute: (SearchIntention)->Unit){
    Column(modifier = modifier.fillMaxSize()) {
        val toSearch 
        TextField(value = , onValueChange = )
    }
}


@Preview(showBackground = true)
@Composable
fun SearchPagePreview(){
    ClimappTheme {
        SearchView(modifier = Modifier, state = SearchState.Loading) {
            
        }
    }
}