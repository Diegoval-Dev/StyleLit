package com.uvg.stylelit.ui.uiStates

import com.uvg.stylelit.data.networking.Cards

data class ItemsUiState(
    //ClothResponse
    val items: List<Cards>,
    val loading: Boolean = false
)
