package com.uvg.stylelit.navigation

sealed class NavigationState(val route: String) {
    object Categories: NavigationState("CategoryMans")
    object Cloth: NavigationState("Cloth")
}