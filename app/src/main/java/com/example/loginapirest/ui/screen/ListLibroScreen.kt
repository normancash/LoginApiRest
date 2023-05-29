package com.example.loginapirest.ui.screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.loginapirest.ui.theme.LoginApiRestTheme
import com.example.loginapirest.ui.viewmodel.LibroViewModel
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext


@Composable
fun ListLibroScreen(navController: NavController) {

    val libroViewModel : LibroViewModel = viewModel()
    /*val state by libroViewModel.state.collectAsState()
    var isLoading by  remember { mutableStateOf(false) }
    var listLibro by remember { mutableListOf() }*/
    val context = LocalContext.current
    val state  by libroViewModel.libroState.collectAsState()
    //var listLibro by remember { mutableListOf() }
    LoginApiRestTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            if (!state.isEmpty()) {
                LazyColumn() {
                    itemsIndexed(items = state) { index, item ->
                        LibroItem(libroItem = item)
                        //Text(text = item.nombre)
                    }
                }
                /*items(usersState) { user ->
                    Text(text = user.name)
                }*/
            }
        }


    }
}