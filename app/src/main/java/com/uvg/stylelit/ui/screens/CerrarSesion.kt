package com.uvg.stylelit.ui.screens

import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.uvg.stylelit.navigation.NavigationState
import com.uvg.stylelit.screens.auth.WelcomeActivitie
import com.uvg.stylelit.ui.theme.MyButton

@Composable
fun CerrarScreen(navController: NavController){

    CerrarBody(navController = navController)
}

@Composable
fun CerrarBody(navController: NavController){
    val context = LocalContext.current
    val auth = FirebaseAuth.getInstance()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        val intent = Intent(context, WelcomeActivitie::class.java)
        MyButton(
            onClick = {
                auth.signOut()
                context.startActivity(intent)
            }
        ){
            Text(
                text = "Cerrar Sesion",
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}