package com.uvg.stylelit.ui.screens

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.uvg.stylelit.components.CardClothe
import com.uvg.stylelit.components.TituloCategoriaSeparador
import com.uvg.stylelit.components.TituloPrincipal
import com.uvg.stylelit.ui.theme.PinkW
import com.uvg.stylelit.ui.theme.PrimaryColorBlue
import com.uvg.stylelit.ui.theme.pinkcom
import com.uvg.stylelit.ui.viewModels.ItemsVMWomen


@Composable
fun ItemsScreenW(navController: NavController,category: String){
    ItemsBody(navController = navController, category = category)
}

@Composable
fun ItemsBody(viewModel: ItemsVMWomen = viewModel(), navController: NavController, category: String) {
    viewModel.getClothes()
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
            TituloPrincipal(text = "WOMAN'S", color = PinkW)
        }
        TituloCategoriaSeparador(text = category, color = pinkcom)

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 160.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(all = 10.dp)
        ) {
            items(viewModel.WItemsUiState.items) { card ->
                CardClothe(id = card.id, text = card.text) {
                    navController.navigate("Cloths/${card.id}")
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