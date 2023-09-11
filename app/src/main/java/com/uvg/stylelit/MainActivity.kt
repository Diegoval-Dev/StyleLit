package com.uvg.stylelit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio4.sidebarLeft
import com.uvg.stylelit.ui.theme.StyleLitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            sidebarLeft(navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StyleLitTheme {
        val navController = rememberNavController()
        sidebarLeft(navController)
    }
}