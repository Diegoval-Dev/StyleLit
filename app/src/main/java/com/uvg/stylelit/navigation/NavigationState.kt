package com.uvg.stylelit.navigation

sealed class NavigationState(val route: String) {

    //Generales
    object Welcome: NavigationState("Welcome")
    object Login: NavigationState("Login")
    object Register: NavigationState("Register")

    //sidebar
    //object Categories: NavigationState("CategoryMans")
    object Cloth: NavigationState("Cloth")
    object ClothMe: NavigationState("ClothMen")
    object Inicio: NavigationState("inicio")
    object Search: NavigationState("search")
}