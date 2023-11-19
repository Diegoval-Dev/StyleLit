package com.uvg.stylelit.screens.auth
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.uvg.stylelit.MainActivity
import com.uvg.stylelit.navigation.NavigationState
import com.uvg.stylelit.ui.theme.StyleLitTheme

class SignUpActivity : ComponentActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StyleLitTheme  {
                RegisterPage(
                    onSignUpnClick = { email, password ->
                        signUp(email, password)
                    }
                )
            }
        }

        auth = Firebase.auth
    }

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            reload()
        }
    }

    private fun reload() {
        auth.currentUser!!.reload().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "Sesion iniciada", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "No se pudo iniciar sesion ${task.exception}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun signUp(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    Toast.makeText(this, "Cuenta creada", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(
                        baseContext,
                        "No se creo la cuenta: ${task.exception}",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }
    }


}




//Inicio de sesión
@Composable
fun RegisterPage(onSignUpnClick: (email: String, password: String) -> Unit){
    //Assets
    val Google =R.drawable.google
    var Facebook = R.drawable.facebook
    val ilustratorWelcome = R.drawable.fondo
    val fondoWelcome = R.drawable.group_36
    var google  = R.drawable.google
    val scrollState = rememberScrollState()


    //inputs
    var email by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF040E1D)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = fondoWelcome),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(scrollState)
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            Text(
                text = stringResource(R.string.registrarme),
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
            Spacer(modifier = Modifier.height(30.dp))

            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)) {
                Text(stringResource(R.string.confirmar_contrase_a) , color = Color.White,  modifier = Modifier.padding(bottom = 5.dp))
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
                onSignUpnClick(email.text, password.text)
            }) {
                Text(stringResource(R.string.register), fontSize = 18.sp)
            }

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(stringResource(R.string.o_registrarme_con), fontSize = 14.sp, color = Color.White)
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


            }


        }
    }
}