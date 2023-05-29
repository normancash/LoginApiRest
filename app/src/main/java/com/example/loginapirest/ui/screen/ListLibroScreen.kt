package com.example.loginapirest.ui.screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.loginapirest.ui.theme.LoginApiRestTheme
import com.example.loginapirest.ui.viewmodel.LibroViewModel
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext


@Composable
fun ListLibroScreen(navController: NavController) {

    val libroViewModel : LibroViewModel = viewModel()
    val state  by libroViewModel.libroState.collectAsState()
    LoginApiRestTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            if (state._loading) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    CircularProgressIndicator()
                }
            }
            if (!state.listLibro.isEmpty()) {
                LazyColumn() {
                    itemsIndexed(items = state.listLibro) { index, item ->
                        LibroItem(libroItem = item,navController)
                        //Text(text = item.nombre)
                    }
                }

            }
        }


    }
}