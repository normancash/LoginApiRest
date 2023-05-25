package com.example.loginapirest.ui.navigate

sealed class Screen(val route : String) {
    object MainScreen : Screen("home")
    object ListLibroScreen : Screen("ListLibro")
    object DetailLibroScreen : Screen("DetailLibro")
}
