package com.example.laboratorio4

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uvg.stylelit.R
import com.uvg.stylelit.navigation.NavigationState
import com.uvg.stylelit.navigation.routingPages

import com.uvg.stylelit.screens.ItemsScreen
import com.uvg.stylelit.screens.auth.LoginPage
import com.uvg.stylelit.ui.screens.Cloths
import com.uvg.stylelit.ui.screens.ItemsScreenW
import com.uvg.stylelit.ui.screens.MensCategoryScreen
import com.uvg.stylelit.ui.screens.MenuRutas.MenuPage
import com.uvg.stylelit.ui.screens.WomenCategoryScreen
import com.uvg.stylelit.ui.theme.DarkBlue
import com.uvg.stylelit.ui.theme.DarkSlateBlue
import com.uvg.stylelit.ui.theme.PrimaryColorBlue
import com.uvg.stylelit.ui.theme.White


import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainLayout(navController: NavController, content: @Composable () -> Unit, onNavigatePerfil: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "StyleLit",
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        onNavigatePerfil()             }
                    ) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.White)
                    }
                },
            )
        }
    ) {
        content()
    }
}



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)@Composable
fun sidebarLeft(){
    val navController = rememberNavController()
    val iconUser = painterResource(id = R.drawable.baseline_person_24)
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    data class DrawerItem(val icon: ImageVector, val route: String, val label: String)
    val items = listOf(
        DrawerItem(Icons.Default.Home, routingPages.InitialPage, "Inicio"),
        DrawerItem(Icons.Default.ShoppingCart, routingPages.categoryPages, "Categorías"),
        DrawerItem(Icons.Default.Place, routingPages.storesPages, "Tiendas"),
        DrawerItem(Icons.Default.Favorite, routingPages.favoritePages, "Destacados"),
        DrawerItem(Icons.Default.Settings, routingPages.configurationPages, "Configuración")

    )
    val selectedItem = remember { mutableStateOf(items[0]) }

    //icons
    val iconList = painterResource(id = R.drawable.baseline_menu_24)
    ModalNavigationDrawer(

        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
            ){
                Spacer(Modifier.height(12.dp))
                //Aqui va el encabezado del sidebar
                items.forEach { item ->
                    NavigationDrawerItem(
                        modifier = Modifier
                            .padding(NavigationDrawerItemDefaults.ItemPadding),
                        icon = { Icon(item.icon, contentDescription = null, tint = DarkSlateBlue) },
                        label = { Text(item.label, color = DarkSlateBlue) },
                        selected = item == selectedItem.value,
                        onClick = {
                            navController.navigate(item.route)
                            scope.launch { drawerState.close() }
                            selectedItem.value = item
                        },

                        )
                }
            }
        },
        content = {
            //Icons
            val iconUSer = painterResource(id = R.drawable.baseline_person_24)
            val iconMenu = painterResource(id = R.drawable.baseline_menu_24)
            //Textos

            NavHost(navController = navController as NavHostController, startDestination = NavigationState.Inicio.route) {

                composable(NavigationState.Inicio.route) {
                    CommonLayout(drawerState) {
                        MenuPage(navController = navController)
                    }
                }

                composable(routingPages.categoryPages) {
                    CommonLayout(drawerState) {
                        WomenCategoryScreen(navController)
                        //MensCategoryScreen(navController)
                    }
                }



                composable(routingPages.storesPages) {
                    CommonLayout(drawerState = drawerState) {
                        "Pagina de tiendas"
                    }
                }

                composable(routingPages.favoritePages) {
                    CommonLayout(drawerState = drawerState) {
                        "Pagina de destacados"
                    }
                }
                composable(routingPages.configurationPages){
                    CommonLayout(drawerState = drawerState) {
                        "pagina de configuración"
                    }
                }

                composable(route = NavigationState.Cloth.route + "/{WomenCategoryScreen}") { backstackEntry ->
                    CommonLayout(drawerState = drawerState) {
                        ItemsScreen(navController, backstackEntry.arguments?.getString("category") ?: "")
                        //ItemsScreenW(navController, backstackEntry.arguments?.getString("WomenCategoryScreen") ?: "")
                    }
                }

                composable(
                    route = "Cloths/{category}",
                    content = { backstackEntry ->
                        val category = backstackEntry.arguments?.getString("category")
                        CommonLayout(drawerState = drawerState) {
                            Cloths(navController = navController, category = category ?: "")
                        }
                    }
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonLayout(drawerState: DrawerState, content: @Composable () -> Unit) {
    val coroutineScope = rememberCoroutineScope() // Obtener CoroutineScope

    Column(modifier = Modifier.fillMaxSize().background(color = PrimaryColorBlue)) {
        // Encabezado
        Row(
            modifier = Modifier
                .fillMaxWidth()
                //.padding(20.dp)
                .background(color = DarkSlateBlue),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            val iconMenu = painterResource(id = R.drawable.baseline_menu_24)

            IconButton(onClick = {
                coroutineScope.launch { // Lanzar dentro del CoroutineScope
                    drawerState.open()

                }
            }) {
                Icon(painter = iconMenu, contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(top = 10.dp))
            }
            Text(
                text = "StyleLit",
                color = White,
                fontSize = 24.sp,
                fontWeight = FontWeight(600),
                modifier = Modifier.padding(vertical = 15.dp, horizontal = 20.dp)
            )
        }

        // Contenido
        content()
    }
}