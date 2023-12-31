package com.uvg.stylelit.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio4.CommonLayout
import com.example.laboratorio4.sidebarLeft
import com.uvg.stylelit.screens.auth.LoginPage
import com.uvg.stylelit.screens.auth.RegisterPage
import com.uvg.stylelit.screens.auth.SignUpActivity
import com.uvg.stylelit.ui.screens.MensCategoryScreen
import com.uvg.stylelit.ui.screens.MenuRutas.MenuPage
//import com.uvg.stylelit.ui.screens.ClothsW

//Aqui iran todas las pantallas que tendremos por separado
object routingPages {
    //Rutas generales
    const val LoginPage = "Login"
    const val RegisterPage = "Register"
    const val MenuPages = "Menu"
    const val CategoryMansPage = "CategoryMans"
    const val CategoryWomansPage = "CategoryWomans"


    //Rutas par el sidebar
    const val layoutInitial = "Account"
    const val InitialPage = "Inicio"
    const val GPTSearch = "Busqueda"
    const val storesPages = "Tiendas"
    const val ShoppingCart = "ShoppingCart"
    const val configurationPages = "Configuracion"
    const val ClothesCards = "CardsClothes"
}

/*
@Composable
fun SetupNavigation() {
    val navController = rememberNavController();
    NavHost(
        navController = navController,
        startDestination = NavigationState.Welcome.route) {

            composable(route = NavigationState.Welcome.route) {
                welcomeScreen(navController)
            }
            composable(route = NavigationState.Login.route) {
                LoginPage()
            }
            composable(route = NavigationState.Register.route) {
                startActivity(Intent(this, SignUpActivity::class.java))
            }
            composable(route = NavigationState.Inicio.route) {
                sidebarLeft()
            }
            composable(route = NavigationState.Cloth.route) {
                Cloths(navController)
            }

    }
}
*/
