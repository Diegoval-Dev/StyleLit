package com.uvg.stylelit.ui.uiStates

import com.uvg.stylelit.data.networking.CategoryResponse

data class CategoryUiState(
    //CategoryResponse
    val categories: List<CategoryResponse>,
    val loading: Boolean = false
)
