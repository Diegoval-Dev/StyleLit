package com.uvg.stylelit.components

import android.os.Bundle
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TituloPrincipal() {
    Text(
        text = "MEN'S",
        style = TextStyle(
            fontSize = 40.sp,
            color = Color(0XFFFFFFFF),
            fontFamily = FontFamily.SansSerif
        ),
        modifier = Modifier
            .width(187.dp)
            .height(45.dp)
            .offset(13.dp, 1.dp)
    )

    Text(
        text = "MEN'S",
        style = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontSize = 40.sp,
            color = Color(0XFF0C95C0)
        ),
        modifier = Modifier
            .width(187.dp)
            .height(45.dp)
            .offset(12.dp, 1.dp)
    )

    Text(
        text = "MEN'S",
        style = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontSize = 40.sp,
            color = Color(0XFFFFFFFF),
        ),
        modifier = Modifier
            .width(187.dp)
            .height(45.dp)
            .offset(10.dp, 1.dp)
    )
}


@Preview
@Composable
fun TitloPrinPreview() {
    MaterialTheme {
        TituloPrincipal()
    }
}