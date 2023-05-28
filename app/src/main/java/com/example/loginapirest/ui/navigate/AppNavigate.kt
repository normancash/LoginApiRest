package com.example.loginapirest.ui.navigate

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.loginapirest.ui.screen.FormLogin
import com.example.loginapirest.ui.screen.ListLibroScreen

@Composable
fun AppNavigate() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreen.FormLoginScreen.route) {
        composable(route= AppScreen.FormLoginScreen.route) {
            FormLogin(navController);
        }
        composable(route= AppScreen.ListLibroScreen.route){
            ListLibroScreen(navController);
        }
       // composable(route= AppScreen.DetailLibroScreen.route){}

    }
}