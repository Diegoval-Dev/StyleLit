package com.uvg.stylelit.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.uvg.stylelit.ui.theme.StyleLitTheme
import com.uvg.stylelit.R
import com.uvg.stylelit.ui.theme.DarkSlateBlue
import com.uvg.stylelit.ui.theme.White


/**
 * Composable que muestra una tarjeta de ropa con su texto.
 *
 * @param painter El painter que se utilizará para dibujar la imagen.
 * @param text El texto que se mostrará en la tarjeta.
 */
@Composable
fun CardClothe(url: String, text: String, onClick: () -> Unit){
    Card (
        modifier = Modifier.clickable(onClick = onClick)
    ){
        Box(
            modifier = Modifier
                .height(160.dp)
        ){
            AsyncImage(
                model = url,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(R.drawable.placeholderimage)
            )
            Box(
                modifier = Modifier
                    .width(88.dp)
                    .height(121.dp)
                    .padding(top = 100.dp)
                    .background(DarkSlateBlue, RoundedCornerShape(0.dp, 20.dp, 20.dp, 0.dp))
            ) {
                Text(
                    text = text,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxWidth(),
                    color = White,
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    fontWeight = FontWeight(300),
                    fontFamily = FontFamily.SansSerif
                )
            }
        }
    }
}

