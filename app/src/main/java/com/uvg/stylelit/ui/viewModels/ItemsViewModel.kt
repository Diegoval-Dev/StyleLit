package com.uvg.stylelit.ui.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uvg.stylelit.R
import com.uvg.stylelit.data.respository.Repository
import com.uvg.stylelit.ui.uiStates.ItemsUiState
import kotlinx.coroutines.launch

class ItemsViewModel(private val repository: Repository = Repository()): ViewModel() {
    var ItemsUiState by mutableStateOf(ItemsUiState(emptyList()))
    private set

    fun getClothes(cardNameS: String){
        ItemsUiState = ItemsUiState(emptyList(), loading = true)
        viewModelScope.launch {
            ItemsUiState = ItemsUiState(
                items = repository.getCards("Man",cardNameS).cards
            )
        }
    }
}