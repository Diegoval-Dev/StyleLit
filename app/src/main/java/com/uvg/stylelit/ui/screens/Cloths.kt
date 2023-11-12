package com.uvg.stylelit.ui.screens

import ClothesViewModel
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.uvg.stylelit.ui.components.ButtonCategory
import com.uvg.stylelit.ui.theme.PrimaryColorBlue
import com.uvg.stylelit.ui.theme.pinkcom

@Composable
fun Cloths(navController: NavController, category: String) {
    val viewModel: ClothesViewModel = viewModel()
    val productDescriptions = viewModel.getProductDescriptions()

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryColorBlue)
            .padding(1.dp)
    ) {
        items(viewModel.ClothesUiState.categories) { category ->
            ButtonCategory(
                text = category,
                color = pinkcom,
                navController = navController,
                cloth = category
            )
            Divider(color = PrimaryColorBlue, thickness = 10.dp)
        }
        item {
            val headerInfo = viewModel.getHeaderInfo()
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .width(50.dp)
                    .background(headerInfo.backgroundColor),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = headerInfo.title,
                    color = headerInfo.textColor,
                    fontSize = headerInfo.fontSize,
                    fontWeight = headerInfo.fontWeight,
                    modifier = Modifier
                        .padding(8.dp)
                        .width(150.dp)
                )
            }
        }
        itemsIndexed(productDescriptions) { index, descriptionList ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Image(
                    painter = painterResource(viewModel.imageCards[index % viewModel.imageCards.size]),
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp)
                        .background(MaterialTheme.colorScheme.background)
                )

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    for (description in descriptionList) {
                        description.split("\n").forEach {
                            Text(
                                text = it,
                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Light
                            )
                        }
                    }
                }
                IconButton(
                    onClick = {
                        // Acción al presionar el botón
                    },
                    modifier = Modifier.size(44.dp)
                ) {
                    Icon(
                        painter = painterResource(viewModel.carritoIcon),
                        contentDescription = "Icono de compras",
                        tint = Color.White,
                        modifier = Modifier.size(53.dp)
                    )
                }
            }
        }
    }
}