package com.uvg.stylelit.ui.screens

import ClothesViewModelMen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.uvg.stylelit.navigation.NavigationState
import com.uvg.stylelit.ui.components.ButtonCategory
import com.uvg.stylelit.ui.components.ClothCard
import com.uvg.stylelit.ui.theme.DarkBlue
import com.uvg.stylelit.ui.theme.PrimaryColorBlue
import com.uvg.stylelit.ui.theme.pinkcom
import com.uvg.stylelit.ui.viewModels.ShopingCartViewModel

@Composable
fun ClothScreenM(navController: NavController, category: String ,cloth: String){
    ClothBodyM(
        navController = navController,
        category = category,
        cloth = cloth
    )
}
@Composable
fun ClothBodyM(viewModel: ClothesViewModelMen = viewModel(), navController: NavController, category: String, cloth: String){
    if(viewModel.ClothesUiState.cloth.isEmpty()) {
        viewModel.getDataM(category, cloth)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .width(50.dp)
            .background(PrimaryColorBlue),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = cloth,
            color = Color.White,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(8.dp)
                .width(150.dp)
        )
    }
    if (viewModel.ClothesUiState.loading){
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }
    }else{
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier
                .fillMaxSize()
                .background(PrimaryColorBlue)
                .padding(1.dp)
        ) {
            items(viewModel.ClothesUiState.cloth) { cloth ->
                ClothCard(
                    clothes = cloth,
                )
            }
        }
    }

}