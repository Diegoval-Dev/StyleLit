package com.uvg.stylelit.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.uvg.stylelit.components.CardClothe
import com.uvg.stylelit.components.TituloCategoriaSeparador
import com.uvg.stylelit.components.TituloPrincipal
import com.uvg.stylelit.components.TituloPrincipalMen
import com.uvg.stylelit.ui.theme.Cyan
import com.uvg.stylelit.ui.theme.DarkBlue
import com.uvg.stylelit.ui.theme.PrimaryColorBlue
import com.uvg.stylelit.ui.viewModels.ItemsViewModel


@Composable
fun ItemsScreen(navController: NavController,category: String){
    ItemsBody(navController = navController, category = category)
}

@Composable
fun ItemsBody(viewModel: ItemsViewModel = viewModel(), navController: NavController, category: String) {
    if(viewModel.ItemsUiState.items.isEmpty()){
        viewModel.getClothes(category)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(PrimaryColorBlue)
                .padding(top = 5.dp, bottom = 10.dp),
            contentAlignment = Alignment.Center
        ) {
            TituloPrincipalMen(text = "MEN'S", color = Cyan)
        }
        TituloCategoriaSeparador(text = category, color = DarkBlue)

        if(viewModel.ItemsUiState.loading){
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator()
            }
        }else{
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 160.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                contentPadding = PaddingValues(all = 10.dp)
            ) {
                items(viewModel.ItemsUiState.items) { card ->
                    CardClothe(url = card.urlImage, text = card.name) {
                        navController.navigate("ClothM/${category}/${card.id}")
                    }
                }
            }
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp)
        )
    }
}