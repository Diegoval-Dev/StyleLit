package com.uvg.stylelit.ui.viewModels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.uvg.stylelit.data.respository.Repository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uvg.stylelit.ui.uiStates.CategoryUiState
import kotlinx.coroutines.launch

class MensCategoryViewModel(private val repository: Repository = Repository()): ViewModel() {
    var MensCategoryUiState by mutableStateOf(CategoryUiState(emptyList()))
        private set

    fun getCategories() {
        MensCategoryUiState = CategoryUiState(emptyList(), loading = true)

        viewModelScope.launch {
            MensCategoryUiState = CategoryUiState(
                categories = repository.getCategories("Man").categories
            )
        }
    }

}