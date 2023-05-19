package com.example.loginapirest

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions

import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginapirest.ui.model.LoginModel
import com.example.loginapirest.ui.theme.LoginApiRestTheme
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.KeyboardType
import androidx.constraintlayout.compose.Visibility

class MainActivity : ComponentActivity() {

    private val loginModel : LoginModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginApiRestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FormLogin(loginModel)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormLogin(loginModel : LoginModel){

    Column(
        modifier = Modifier.fillMaxSize()
        , verticalArrangement = Arrangement.Center
        , horizontalAlignment = Alignment.CenterHorizontally
    )
    {
           val context = LocalContext.current

           TextField(value = loginModel.name
               , onValueChange = {loginModel.name = it}
               ,label={Text(text="user")}
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(value = loginModel.password
                , onValueChange = {loginModel.password = it}
                ,label={Text(text="password")}
                ,keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)

            )
            Button(onClick = {
                    val loginResponse = loginModel.onSummit(context) }
                   ,modifier = Modifier.padding(top = 16.dp) )
            {
                Text(text="Ok")
            }
    }
}