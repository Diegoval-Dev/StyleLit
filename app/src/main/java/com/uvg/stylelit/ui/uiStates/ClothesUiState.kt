package com.uvg.stylelit.ui.uiStates
import com.uvg.stylelit.data.networking.Card

data class ClothesUiState(
    val categories: List<String>,
    val loading: Boolean = false
)