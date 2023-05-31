package com.example.loginapirest.ui.navigate

sealed class AppScreen(val route : String) {
    object FormLogin : AppScreen("login")
    object ListLibro : AppScreen("listalibro")
   /* object DetailLibroScreen : AppScreen("detaillibro/${NavArg.Item.key}"){
        fun createRoute(item : LibroItem) = "detaillibro/${Uri.encode(Json.encodeToJsonElement(item).toString())}"
    }*/
    object DetailLibro : AppScreen("detaillibro")

    enum class NavArg(val key : String) {
        Item("item")
    }

}
