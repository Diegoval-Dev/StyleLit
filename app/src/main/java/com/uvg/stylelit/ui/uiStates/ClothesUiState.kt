package com.uvg.stylelit.ui.uiStates

import com.uvg.stylelit.data.networking.Clothes

data class ClothesUiState(
    val cloth: List<Clothes>,
    val loading: Boolean = false
)