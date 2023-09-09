package com.uvg.stylelit.components
//Referencia de: https://developer.android.com/jetpack/compose/text?hl=es-419

import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun TitleWithShadow(text: String, shadowColor: Color) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 24.sp,
            shadow = Shadow(
                color = shadowColor,
                offset = Offset(2.0f, 4.0f),
                blurRadius = 3f
            )
        )
    )
}

@Composable
fun TitleWithShadowDemo() {
    TitleWithShadow(
        text = "Mi Título",
        shadowColor = Color(0XFF0C95C0)
    )
}

@Preview
@Composable
fun TitleWithShadowPreview() {
    TitleWithShadow(
        text = "Mi Título",
        shadowColor = Color(0XFF0C95C0)
    )
}

