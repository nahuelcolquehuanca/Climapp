package com.example.climapp.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.climapp.repository.RepoAPI
import com.example.climapp.repository.Repository
import com.example.climapp.repository.models.City
import kotlinx.coroutines.launch

class SearchViewModel(val repository: Repository): ViewModel() {

    companion object{
        //sirve para construir el viewmodel ya que viewModel() en SearchPage no acepta parametros
        val factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                //elejimos que repositorio usar
                val repository = RepoAPI()
                SearchViewModel(repository)
            }
        }
    }

    var uiState by mutableStateOf<SearchState>(SearchState.Empty)

    fun execute(intention: SearchIntention){
        when(intention){
            is SearchIntention.Search-> search(intention.city)
            SearchIntention.Delete-> delete()
        }
    }


    private fun search(city: String){
        uiState = SearchState.Loading
        viewModelScope.launch {
            //llamo a funcion para obtener ciudades coincidentes con busqueda
            val list = repository.searchCity("CABA")
            //SearchState.Success(list)
        }
    }
    private fun delete(){
        uiState = SearchState.Empty
    }

}

