package com.uvg.stylelit.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio4.sidebarLeft
import com.uvg.stylelit.screens.auth.LoginPage
import com.uvg.stylelit.screens.auth.RegisterPage
import com.uvg.stylelit.screens.auth.welcomeScreen
import com.uvg.stylelit.ui.screens.MensCategoryScreen
import com.uvg.stylelit.ui.screens.MenuRutas.MenuPage

//Aqui iran todas las pantallas que tendremos por separado
object routingPages {
    //Rutas generales
    const val welcomePage = "Welcome"
    const val LoginPage = "Login"
    const val RegisterPage = "Register"
    const val MenuPages = "Menu"
    const val CategoryMansPage = "CategoryMans"
    const val CategoryWomansPage = "CategoryWomans"


    //Rutas par el sidebar
    const val layoutInitial = "Account"
    const val InitialPage = "Inicio"
    const val categoryPages = "Categoria"
    const val storesPages = "Tiendas"
    const val favoritePages = "Destacados"
    const val configurationPages = "Configuracion"
}


@Composable
fun SetupNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = routingPages.welcomePage) {
        composable(routingPages.welcomePage) { welcomeScreen(navController) }
        composable(routingPages.LoginPage) { LoginPage(navController) }
        composable(routingPages.RegisterPage) { RegisterPage(navController)}
        composable(routingPages.MenuPages) { MenuPage(navController) }
        composable(routingPages.categoryPages) { MensCategoryScreen(navController) }
        composable(routingPages.InitialPage) {sidebarLeft(navController)}

    }
}

