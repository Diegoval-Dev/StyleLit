package com.uvg.stylelit.screens.auth
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import com.uvg.stylelit.R
import com.uvg.stylelit.navigation.NavigationState
import com.uvg.stylelit.navigation.routingPages
import com.uvg.stylelit.ui.theme.AtkinsonFont
import com.uvg.stylelit.ui.theme.MyButton
import com.uvg.stylelit.ui.theme.StyleLitTheme

class WelcomeActivitie : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StyleLitTheme {
                WelcomeScreen()
            }
        }
    }
}
@SuppressLint("SuspiciousIndentation")
@Composable
fun WelcomeScreen(){
    val LoginPage = stringResource(R.string.loginText)
    val ilustratorWelcome = R.drawable.fondo
    val fondoWelcome = R.drawable.group_36
    val scrollState = rememberScrollState()

    Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
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
                val context = LocalContext.current
                MyButton(
                    onClick = {
                        val intent = Intent(context, LoginActivity::class.java)
                        context.startActivity(intent)
                    }
                ) {
                    Text(stringResource(R.string.login), fontSize = 18.sp)
                }


                MyButton(
                    onClick = {
                        val intent = Intent(context, SignUpActivity::class.java)
                        context.startActivity(intent)
                    }
                ) {
                    Text(stringResource(R.string.register),fontSize = 18.sp)
                }
            }
        }

}