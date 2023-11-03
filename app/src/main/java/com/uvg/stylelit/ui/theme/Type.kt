package com.uvg.stylelit.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.uvg.stylelit.R


val AtkinsonFont = FontFamily(
    Font(R.font.atkinson_hyperlegible_bold, FontWeight.Bold ),
    Font(R.font.atkinson_hyperlegible_italic,  FontWeight.Normal, FontStyle.Italic ),
    Font(R.font.atkinson_hyperlegible_regular, FontWeight.Normal),

)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

