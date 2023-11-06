package com.uvg.stylelit.screens.auth
import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.uvg.stylelit.R
import com.uvg.stylelit.navigation.NavigationState
import com.uvg.stylelit.navigation.routingPages
import com.uvg.stylelit.ui.theme.AtkinsonFont
import com.uvg.stylelit.ui.theme.MyButton

@SuppressLint("SuspiciousIndentation")
@Composable
fun welcomeScreen(navController: NavController){
    val LoginPage = stringResource(R.string.loginText)
    val ilustratorWelcome = R.drawable.fondo
    val fondoWelcome = R.drawable.group_36
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF040E1D)), // Color de fondo de la pantalla
            contentAlignment = Alignment.Center
        ) {
            // Suponiendo que tienes un recurso SVG llamado "background_image"
            Image(
                painter = painterResource(id = fondoWelcome),
                contentDescription = null, // Aquí podrías agregar una descripción para accesibilidad
                contentScale = ContentScale.Crop,  // Esto se asegura de que la imagen cubra todo el espacio, recortando si es necesario
                modifier = Modifier.fillMaxSize()  // Esto hará que la imagen llene toda la pantalla
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = stringResource(R.string.stylelit),
                    fontSize = 85.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    fontFamily = AtkinsonFont
                )

                Spacer(modifier = Modifier.height(16.dp))



                Spacer(modifier = Modifier.height(32.dp))

                // Espacio para tu SVG aquí
                // ...
                Image(painter = painterResource(id =ilustratorWelcome), contentDescription ="", modifier = Modifier.width(300.dp) )

                Spacer(modifier = Modifier.height(32.dp))
                MyButton(onClick = { navController.navigate(NavigationState.Login.route) }) {
                    Text(stringResource(R.string.login), fontSize = 18.sp)
                }


                MyButton(onClick = {  navController.navigate(NavigationState.Register.route) }) {
                    Text(stringResource(R.string.register),fontSize = 18.sp)
                }
            }
        }

}