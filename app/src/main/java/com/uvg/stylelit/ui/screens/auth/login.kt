package com.uvg.stylelit.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uvg.stylelit.R
import com.uvg.stylelit.navigation.routingPages
import com.uvg.stylelit.ui.theme.AtkinsonFont
import com.uvg.stylelit.ui.theme.MyButton
import okhttp3.internal.wait
import androidx.compose.ui.res.vectorResource
import com.example.laboratorio4.CommonLayout
import com.example.laboratorio4.sidebarLeft
import com.uvg.stylelit.navigation.NavigationState
import com.uvg.stylelit.navigation.SetupNavigation
import com.uvg.stylelit.ui.screens.MenuRutas.MenuPage

//Inicio de sesión
@Composable
fun LoginPage(navController: NavController){
    //Assets
    val Google =R.drawable.google
    var Facebook = R.drawable.facebook
    val ilustratorWelcome = R.drawable.fondo
    val fondoWelcome = R.drawable.group_36
    var google  = R.drawable.google


    //inputs
    var email by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }
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
            Spacer(modifier = Modifier.height(80.dp))
            Text(
                text = stringResource(R.string.loginText),
                fontSize = 45.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White,
                fontFamily = AtkinsonFont
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)) {
                Text(stringResource(R.string.correoText), color = Color.White, modifier = Modifier.padding(bottom = 5.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White, shape = RoundedCornerShape(10.dp))
                        .height(50.dp)
                        .padding(start = 16.dp)
                ) {
                    BasicTextField(
                        value = email,
                        onValueChange = { email = it },
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 12.dp),  // Ajusta este valor para centrar verticalmente el texto
                        textStyle = TextStyle(fontSize = 20.sp),
                        singleLine = true
                    )
                }

            }

            Spacer(modifier = Modifier.height(30.dp))

            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)) {
                Text(stringResource(R.string.password) , color = Color.White,  modifier = Modifier.padding(bottom = 5.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White, shape = RoundedCornerShape(10.dp))
                        .height(50.dp)
                        .padding(start = 16.dp)
                ) {
                    BasicTextField(
                        value = password,
                        onValueChange = { password = it },
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 12.dp),  // Ajusta este valor para centrar verticalmente el texto
                        textStyle = TextStyle(fontSize = 20.sp),
                        singleLine = true
                    )
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 10.dp)  // Ajusta el padding superior según sea necesario
            ) {
                Spacer(modifier = Modifier.weight(1f))  // Empuja el texto hacia la derecha
                Text(stringResource(R.string.ForgottPass), fontSize = 14.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.height(32.dp))
            MyButton(onClick = {
                navController.navigate(NavigationState.Inicio.route)
            }) {
                Text(stringResource(R.string.loginText), fontSize = 18.sp)
            }
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(stringResource(R.string.o_inicia_sesi_n_con), fontSize = 14.sp, color = Color.White)
                Row {
                    Image(
                        painter = painterResource(id = Google),
                        contentDescription = null,
                        modifier = Modifier
                            .width(50.dp)
                            .padding(10.dp),
                        colorFilter = ColorFilter.tint(Color.White),
                        contentScale = ContentScale.Fit
                    )
                    Image(
                        painter = painterResource(id = Facebook),
                        contentDescription = null,
                        modifier = Modifier
                            .width(50.dp)
                            .padding(10.dp),
                        colorFilter = ColorFilter.tint(Color.White),
                        contentScale = ContentScale.Fit
                    )
                }
                Row {
                    Text(stringResource(R.string.no_tienes_una_cuenta), fontSize = 14.sp, color = Color.White, modifier = Modifier.padding(start = 2.dp))
                    Text(text = stringResource(R.string.crear), fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.White,
                        modifier = Modifier.clickable { navController.navigate(NavigationState.Register.route)}.padding(start = 5.dp)
                    )
                }

            }


        }
    }
}