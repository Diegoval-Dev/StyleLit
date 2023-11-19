package com.uvg.stylelit.ui.viewModels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uvg.stylelit.data.respository.Repository
import com.uvg.stylelit.ui.uiStates.ItemsUiState
import kotlinx.coroutines.launch

class ItemsVMWomen(private val repository: Repository = Repository()): ViewModel() {
    var WItemsUiState by mutableStateOf(ItemsUiState(emptyList()))
    private set

    fun getClothes(cardNameS: String){
        WItemsUiState = ItemsUiState(emptyList(), loading = true)
        viewModelScope.launch {
            WItemsUiState = ItemsUiState(
                items = repository.getCards("Woman",cardNameS).cards
            )
        }
    }
}