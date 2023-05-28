package com.example.loginapirest.ui.navigate

sealed class AppScreen(val route : String) {
    object FormLoginScreen : AppScreen("form_login")
    object ListLibroScreen : AppScreen("list_libro")
    //object DetailLibroScreen : AppScreen("DetailLibro")
}
