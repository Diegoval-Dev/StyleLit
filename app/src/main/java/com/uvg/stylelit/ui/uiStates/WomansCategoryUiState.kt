package com.uvg.stylelit.ui.uiStates

import com.uvg.stylelit.data.networking.CategoryResponse

data class WomansCategoryUiState(
    //CategoryResponse
    val categories: List<String>,
    val loading: Boolean = false
)
