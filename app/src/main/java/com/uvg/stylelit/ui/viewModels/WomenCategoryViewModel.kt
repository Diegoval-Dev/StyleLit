package com.uvg.stylelit.ui.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.uvg.stylelit.data.respository.Repository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uvg.stylelit.ui.uiStates.CategoryUiState
import kotlinx.coroutines.launch

class WomenCategoryViewModel(private val repository: Repository = Repository()): ViewModel() {
    var WomansCategoryUiState by mutableStateOf(CategoryUiState(emptyList()))
        private set

    /*val tempCategories: List<String> =  listOf("Camisas", "Pantalones",
        "Chaquetas & Abrigos", "Vestidos", "Faldas", "Ropa Deportiva",
        "Ropa Interior", "Accesorios", "Ropa de baño")*/
    fun getCategories() {
        WomansCategoryUiState = CategoryUiState(emptyList(), loading = true)

        viewModelScope.launch {
            WomansCategoryUiState = CategoryUiState(
                categories = repository.getCategories("Woman").categories
            )
        }
    }
}