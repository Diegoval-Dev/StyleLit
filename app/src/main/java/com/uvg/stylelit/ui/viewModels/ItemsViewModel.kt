package com.uvg.stylelit.ui.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uvg.stylelit.R
import com.uvg.stylelit.data.networking.Card
import com.uvg.stylelit.data.respository.Repository
import com.uvg.stylelit.ui.uiStates.ItemsUiState
import kotlinx.coroutines.launch

class ItemsViewModel(private val repository: Repository = Repository()): ViewModel() {
    var ItemsUiState by mutableStateOf(ItemsUiState(emptyList()))
    private set
    val camisas = mutableListOf<Card>(
        Card(id = R.drawable.c__1_, text = "P. Larga"),
        Card(id = R.drawable.c__2_, text = "C. Largas"),
        Card(id = R.drawable.c__3_, text = "C. Corta"),
        Card(id = R.drawable.c__4_, text = "Playeras"),
        Card(id = R.drawable.c__8_, text = "Dibujos"),
        Card(id = R.drawable.c__7_, text = "Deportiva"),
        Card(id = R.drawable.c__5_, text = "Sin Mangas"),
        Card(id = R.drawable.c__6_, text = "Cuadros"),
        Card(id= R.drawable.c__9_, text = "Holgadas"),
        Card(id= R.drawable.c__10_, text = "P. Sin Manga")
    )
    fun getClothes(){
        ItemsUiState = ItemsUiState(emptyList(), loading = true)
        viewModelScope.launch {
            ItemsUiState = ItemsUiState(
                items = camisas
            )
        }
    }
}