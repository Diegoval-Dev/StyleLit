package com.uvg.stylelit.screens.auth
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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

//Inicio de sesión
@Composable
fun RegisterPage(navController: NavController){
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
            contentDescription = null,
            modifier = Modifier.fillMaxSize()  // Esto hará que la imagen llene toda la pantalla
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            Text(
                text = "Registrarme",
                fontSize = 45.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White,
                fontFamily = AtkinsonFont
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)) {
                Text("Correo Electrónico", color = Color.White, modifier = Modifier.padding(bottom = 5.dp))
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
                Text("Contraseña" , color = Color.White,  modifier = Modifier.padding(bottom = 5.dp))
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
            Spacer(modifier = Modifier.height(30.dp))

            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)) {
                Text("Confirmar contraseña" , color = Color.White,  modifier = Modifier.padding(bottom = 5.dp))
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

            Spacer(modifier = Modifier.height(32.dp))
            MyButton(onClick = {
                navController.navigate(routingPages.InitialPage)
            }) {
                Text("Registrarme", fontSize = 18.sp)
            }
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("O registrarme con ", fontSize = 14.sp, color = Color.White)
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
                    Text("Tienes una cuenta? ", fontSize = 14.sp, color = Color.White)
                    Text(text = "Iniciar sesión", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.White)
                }

            }


        }
    }
}