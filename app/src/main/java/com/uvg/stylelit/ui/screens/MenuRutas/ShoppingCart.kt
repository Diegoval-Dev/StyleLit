package com.uvg.stylelit.ui.screens.MenuRutas

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.uvg.stylelit.ui.components.CartCard
import com.uvg.stylelit.ui.components.ClothCard
import com.uvg.stylelit.ui.theme.PrimaryColorBlue
import com.uvg.stylelit.ui.theme.pinkcom
import com.uvg.stylelit.ui.viewModels.ShopingCartViewModel


@Composable
fun ShopingScreen(navController: NavController){
    ShopingBody(navController = navController)
}

@Composable
fun ShopingBody(navController: NavController){
    val viewModelShoppingCart: ShopingCartViewModel = viewModel()
    viewModelShoppingCart.getCart()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .width(50.dp)
            .background(PrimaryColorBlue),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Shopping Cart",
            color = Color.White,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(8.dp)
                .width(150.dp)
        )
    }
    if(viewModelShoppingCart.shoppingCartUiState.shopingItems.isEmpty()){
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "El carrito se encuentra vacio",
                color = Color.White,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(8.dp)
                    .width(150.dp)
            )
        }

    }else{
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier
                .fillMaxSize()
                .background(PrimaryColorBlue)
                .padding(1.dp)
        ) {
            items(viewModelShoppingCart.shoppingCartUiState.shopingItems) { cloth ->
                CartCard(
                    clothes = cloth,
                    viewModel = viewModelShoppingCart
                )
            }
        }
    }
}