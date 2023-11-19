package com.uvg.stylelit.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.uvg.stylelit.R
import com.uvg.stylelit.ui.theme.PrimaryColorBlue

@Composable
fun ClothCard(url: String, marca: String, tallas: String, precio: String, colores: String){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(PrimaryColorBlue),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        AsyncImage(
            model = url,
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
                text = "-Marca: $marca",
                color = Color.White
            )
            Text(
                text = "-Tallas: $tallas",
                color = Color.White
            )
            Text(
                text = "-Precio: Q$precio",
                color = Color.White
            )
            Text(
                text = "-Colores: $colores",
                color = Color.White
            )
        }
        IconButton(
            onClick = {
                // Acción al presionar el botón
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