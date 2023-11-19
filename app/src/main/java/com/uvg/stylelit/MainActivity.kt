package com.uvg.stylelit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio4.sidebarLeft
import com.uvg.stylelit.screens.auth.LoginPage
import com.uvg.stylelit.ui.theme.StyleLitTheme

// MainActivity.kt
class MainActivity : ComponentActivity() {
/*

 override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

                val navController = rememberNavController()
            sidebarLeft(navController)

            //welcomeScreen()
        }
    }

* */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            sidebarLeft()
        }
    }

}



