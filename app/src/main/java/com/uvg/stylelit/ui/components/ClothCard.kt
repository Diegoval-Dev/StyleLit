package com.uvg.stylelit.ui.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.uvg.stylelit.R
import com.uvg.stylelit.data.networking.Clothes
import com.uvg.stylelit.ui.screens.MenuRutas.ShopingBody
import com.uvg.stylelit.ui.theme.PrimaryColorBlue
import com.uvg.stylelit.ui.viewModels.ShopingCartViewModel
import com.uvg.stylelit.ui.viewModels.repositoryCart

@Composable
fun ClothCard(clothes: Clothes){

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(PrimaryColorBlue),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        AsyncImage(
            model = clothes.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp),
            contentScale = ContentScale.Crop,
            placeholder = painterResource(R.drawable.placeholderimage)
        )
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .width(200.dp)
                .padding(start = 10.dp)
        ) {
            Text(
                text = "-Marca: ${clothes.brand}",
                color = Color.White
            )
            Text(
                text = "-Tallas: ${clothes.sizes}",
                color = Color.White
            )
            Text(
                text = "-Precio: Q${clothes.price}",
                color = Color.White
            )
            Text(
                text = "-Colores: ${clothes.colors}",
                color = Color.White
            )
        }
        val context = LocalContext.current
        IconButton(
            onClick = {
                repositoryCart.addShopingItems(clothes)
                Toast.makeText(context, "Producto Agregado", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.size(44.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_carritos),
                contentDescription = "Icono de compras",
                tint = Color.White,
                modifier = Modifier.size(53.dp)
            )
        }
    }
}


