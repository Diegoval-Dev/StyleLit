package com.uvg.stylelit.ui.theme

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun MyButtonStyle(): ButtonColors {
    return ButtonDefaults.buttonColors(
        containerColor = Color(0xFF040E1D),
        contentColor = Color.White
    )
}
@Composable
fun MyButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .padding(16.dp)
            .defaultMinSize(minWidth = 190.dp, minHeight = 70.dp),
        colors = MyButtonStyle(),
        shape = MyButtonShape(),
        content = content
    )
}

@Composable
fun MyButtonShape(): Shape {
    return RoundedCornerShape(12.dp)  // Ajusta el valor a tu preferencia
}
