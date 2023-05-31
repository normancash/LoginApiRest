package com.example.loginapirest.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.loginapirest.ui.model.LibroItem
import com.example.loginapirest.ui.navigate.AppScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailLibroScreen(navController: NavController,libroItem : LibroItem) {
    val item  by remember {mutableStateOf(libroItem)}
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
            BodyContent(item, modifier = Modifier.padding(padding))
        }

    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun BodyContent(item: LibroItem, modifier: Modifier) {
    Box( modifier = modifier)
    {
        Card(
            modifier = Modifier
                .padding(8.dp, 4.dp)
                .fillMaxWidth()
                .height(110.dp), shape = RoundedCornerShape(8.dp)
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
                    /*TextField(value = item.id,
                        onValueChange = { item.id = it },
                        label = { Text(text = "Id") },
                        singleLine = true,
                        maxLines = 1

                    )*/
                    Text(text = item.id.toString(),
                         style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = item.nombre,
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold
                    )
                  
                }
            }
        }

    }
}