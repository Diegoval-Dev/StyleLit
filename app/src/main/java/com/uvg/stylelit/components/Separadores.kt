package com.uvg.stylelit.components
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.MaterialTheme


@Composable
fun Componentes() {
    Box(
        modifier = Modifier
            .width(420.dp)
            .height(38.dp)
            .offset(0.dp, 0.dp)
            .background(Color(0XFF2B4E77))
            .border(20.dp, Color.Transparent, RoundedCornerShape(20.dp))
    ) {
        Text(
            text = "Camisas",
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier
                .padding(8.dp)
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