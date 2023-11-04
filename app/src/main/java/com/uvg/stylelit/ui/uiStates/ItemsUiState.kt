package com.uvg.stylelit.ui.uiStates

import com.uvg.stylelit.data.networking.Card

data class ItemsUiState(
    //ClothResponse
    val items: List<Card>,
    val loading: Boolean = false
)
