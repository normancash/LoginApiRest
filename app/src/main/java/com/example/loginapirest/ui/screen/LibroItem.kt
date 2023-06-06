package com.example.loginapirest.ui.screen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.loginapirest.R
import com.example.loginapirest.ui.config.DataStoreManager
import com.example.loginapirest.ui.model.LibroItem
import com.example.loginapirest.ui.navigate.AppScreen


@Composable
fun LibroItem(libroItem: LibroItem, navController: NavController, modifier: Modifier) {
    val context = LocalContext.current
    val dataStore = DataStoreManager(context)
    val savedValue = dataStore.getValue.collectAsState(initial = "")
    Log.d("SAVED VALUE",savedValue.value.toString())
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
                        .clickable {
                            navController.currentBackStackEntry?.savedStateHandle?.set("item",libroItem)
                            navController.navigate(AppScreen.DetailLibro.route + "/DETAIL")
                         }

                ) {


                        Text(
                            text = libroItem.nombre,
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold
                        )
                        IconButton(onClick = {
                            navController.currentBackStackEntry?.savedStateHandle?.set("item",libroItem)
                            navController.navigate(AppScreen.DetailLibro.route + "/UPDATE")}) {
                            Icon(painter = painterResource(R.drawable.ic_desing_libro_update), contentDescription =null )
                        }

                }
            }
        }

}