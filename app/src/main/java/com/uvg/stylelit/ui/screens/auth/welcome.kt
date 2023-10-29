package com.uvg.stylelit.screens.auth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.res.vectorResource
import com.uvg.stylelit.R

@Composable
fun welcomeScreen(){
    
    val MyButtonColors = ButtonDefaults.buttonColors(

        contentColor = Color.White,                    // Color del texto/content del botón
        disabledContentColor = Color.DarkGray          // Color del texto/content cuando el botón está deshabilitado
    )
    val ilustratorWelcome = R.drawable.fondo
    val fondoWelcome = R.drawable.group_36

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF040E1D)), // Color de fondo de la pantalla
            contentAlignment = Alignment.Center
        ) {
            // Suponiendo que tienes un recurso SVG llamado "background_image"
            val backgroundImage: ImageVector = ImageVector.vectorResource(ilustratorWelcome)

            Image(
                imageVector = backgroundImage,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "StyleLit",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "busca tu tienda favorita",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Espacio para tu SVG aquí
                // ...
                Image(painter = painterResource(id =fondoWelcome), contentDescription ="" )

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = { /* acción para iniciar sesión */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                ) {
                    Text(text = "Iniciar sesión")
                }

                Button(
                    onClick = { /* acción para registrarse */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Registrarse")
                }
            }
        }

}