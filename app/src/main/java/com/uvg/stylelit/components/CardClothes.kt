package com.uvg.stylelit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvg.stylelit.ui.theme.StyleLitTheme
import com.uvg.stylelit.R


/**
 * Composable que muestra una tarjeta de ropa con su texto.
 *
 * @param painter El painter que se utilizará para dibujar la imagen.
 * @param text El texto que se mostrará en la tarjeta.
 */
@Composable
fun CardClothe(painter: Painter, text: String){
    Card {
        Box(
            modifier = Modifier
                .width(160.dp)
                .height(160.dp)
        ){
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .width(88.dp)
                    .height(121.dp)
                    .padding(top = 100.dp)
                    .background(Color(0xFF1D2B3C), RoundedCornerShape(0.dp, 20.dp, 20.dp, 0.dp))
            ) {
                Text(
                    text = text,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxWidth(),
                    color = Color(0xffffffff),
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    fontWeight = FontWeight(300),
                    fontFamily = FontFamily.SansSerif
                )
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    StyleLitTheme {
        CardClothe(painter = painterResource(id = R.drawable.ic_launcher_background), text = "Prueba")
    }
}