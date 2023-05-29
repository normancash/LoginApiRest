package com.example.loginapirest.ui.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavController
import com.example.loginapirest.ui.model.LibroItem
import com.example.loginapirest.ui.navigate.AppScreen

@Composable
fun DetailLibroScreen(item : LibroItem, navController: NavController) {
    Text(text=item.nombre)
    /*deailModel : DetailModel = viewModel();
    item by remember (mutableStateOf(LibroItem))
    Text(text=item.nombre)

    Column() {
        TextFiel() {text = {item.nombre
        }}
    }
    Boton(
        onClick = {detailModel :: saveItem(item)}
    ) {
        Text() {text = salvar}
    }*/
}