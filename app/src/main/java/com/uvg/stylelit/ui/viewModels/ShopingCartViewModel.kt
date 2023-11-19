package com.uvg.stylelit.ui.viewModels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uvg.stylelit.data.networking.Clothes
import com.uvg.stylelit.data.respository.Repository
import com.uvg.stylelit.ui.uiStates.ShopingCartUiState
import kotlinx.coroutines.launch

var repositoryCart: Repository = Repository()
class ShopingCartViewModel: ViewModel() {

    var shoppingCartUiState by mutableStateOf(ShopingCartUiState(mutableListOf()))
    fun getCart() {
        shoppingCartUiState = ShopingCartUiState(
            repositoryCart.getShopingItems().clothes
        )
    }
    fun removeCart(cloth: Clothes) {
        repositoryCart.removeItem(cloth)
        shoppingCartUiState = ShopingCartUiState(
            repositoryCart.getShopingItems().clothes
        )
    }

}