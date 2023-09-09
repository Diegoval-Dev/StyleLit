package com.uvg.stylelit.components
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily


@Composable
fun Componentes() {
    Box(
        modifier = Modifier
            .width(420.dp)
            .height(38.dp)
            .background(Color(0XFF2B4E77))
            .border(20.dp, Color.Transparent, RoundedCornerShape(20.dp))
    ) {
        Text(
            text = "Camisas",
            style = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontSize = 20.sp,
                color = Color(0XFFFFFFFF),
            ),
            modifier = Modifier
                .padding(6.dp)
        )
    }
}

@Preview
@Composable
fun RectanguloConTextoPreview() {
    MaterialTheme {
        Componentes()
    }
}