package com.example.loginapirest.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.loginapirest.ui.navigate.AppNavigate
import com.example.loginapirest.ui.theme.LoginApiRestTheme

@Composable
fun ListLibroScreen(navController: NavController) {
    LoginApiRestTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Text(text = "Lista de Libro")
        }
    }
}