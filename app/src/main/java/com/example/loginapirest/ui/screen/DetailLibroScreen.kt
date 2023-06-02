package com.example.loginapirest.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.loginapirest.ui.model.DtoLibro
import com.example.loginapirest.ui.model.LibroItem
import com.example.loginapirest.ui.navigate.AppScreen
import com.example.loginapirest.ui.viewmodel.LibroItemViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailLibroScreen(navController: NavController, libroItem: LibroItem, oper: String?) {
    var item  by remember {mutableStateOf(libroItem)}
    var detail : LibroItemViewModel = viewModel()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = item.nombre
                            ,color=Color.White
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigate(AppScreen.ListLibro.route) }
                            ,colors= IconButtonDefaults.filledIconButtonColors(contentColor = Color.White)
                        ) {
                            Icon(Icons.Filled.ArrowBack, "backIcon")
                        }
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Blue),

                    )
            }
        ) {
            padding ->
            if (oper.equals("UPDATE")) {
                AddBodyContent(navController, item, modifier = Modifier.padding(padding), detail)
            }
            if (oper.equals("DETAIL")) {
                DetailBodyContent(navController, item, modifier = Modifier.padding(padding), detail)
            }
        }

    }
}

@Composable
fun DetailBodyContent(navController: NavController, item: LibroItem, modifier: Modifier, detail: LibroItemViewModel) {

}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun AddBodyContent(navController: NavController, item: LibroItem, modifier: Modifier, detail : LibroItemViewModel) {
    var id by rememberSaveable { mutableStateOf(item.id)}
    var name by rememberSaveable { mutableStateOf(item.nombre) }
    val libroItemModel : LibroItemViewModel = viewModel()
    val context = LocalContext.current
    val state by detail.state.collectAsState();

    if (state) {
        navController.navigate(AppScreen.ListLibro.route)
    }
    Box( modifier = modifier)
    {
        Card(
            modifier = Modifier
                .padding(8.dp, 4.dp)
                .fillMaxWidth()
                , shape = RoundedCornerShape(8.dp)
            ,elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        ) {
            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)

                ) {
                    Text(text = "ID: ${id.toString()}",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.padding(4.dp))
                    TextField(value = name,
                        onValueChange = { name = it },
                        label = { Text (text = "Name") },
                        singleLine = true,
                        maxLines = 1
                    )
                    Button(onClick = {detail.addLibro(DtoLibro(id,name))}
                    )
                    {
                        Text(text = "Salvar")
                    }
                }
            }
        }

    }
}