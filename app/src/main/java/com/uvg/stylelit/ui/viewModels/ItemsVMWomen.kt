package com.uvg.stylelit.ui.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uvg.stylelit.R
import com.uvg.stylelit.data.networking.Card
import com.uvg.stylelit.data.respository.Repository
import com.uvg.stylelit.ui.uiStates.WItemsUiState
import kotlinx.coroutines.launch

class ItemsVMWomen(private val repository: Repository = Repository()): ViewModel() {
    var WItemsUiState by mutableStateOf(WItemsUiState(emptyList()))
    private set
    val camisas = mutableListOf<Card>(
        Card(id = R.drawable.b1, text = "B. Larga"),
        Card(id = R.drawable.b2, text = "C. Largas"),
        Card(id = R.drawable.b3, text = "C. Corta"),
        Card(id = R.drawable.b4, text = "Playeras"),
        Card(id = R.drawable.b5, text = "Dibujos"),
        Card(id = R.drawable.b6, text = "Deportiva"),
        Card(id = R.drawable.b7, text = "Sin Mangas"),
        Card(id = R.drawable.b8, text = "Cuadros"),
        Card(id = R.drawable.b9, text = "Holgadas"),
        Card(id = R.drawable.b10, text = "P. Sin Manga")
    )
    fun getClothes(){
        WItemsUiState = WItemsUiState(emptyList(), loading = true)
        viewModelScope.launch {
            WItemsUiState = WItemsUiState(
                items = camisas
            )
        }
    }
}