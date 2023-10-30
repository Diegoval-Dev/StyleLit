package com.uvg.stylelit.ui.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.uvg.stylelit.data.respository.Repository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uvg.stylelit.data.networking.CategoryResponse
import com.uvg.stylelit.ui.uiStates.MensCategoryUiState
import kotlinx.coroutines.launch

class MensCategoryViewModel(private val repository: Repository = Repository()): ViewModel() {
    var MensCategoryUiState by mutableStateOf(MensCategoryUiState(emptyList()))
        private set

    val tempCategories: List<String> =  listOf("Pantalones", "Camisas",
        "Accesorios", "Chaquetas & Abrigos",
        "Ropa Deportiva", "Ropa Interior")
    fun getCategories() {
        MensCategoryUiState = MensCategoryUiState(emptyList(), loading = true)

        viewModelScope.launch {
            MensCategoryUiState = MensCategoryUiState(
                categories = tempCategories
            )
        }
    }

}