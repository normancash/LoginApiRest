package com.example.loginapirest.ui.model

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.setValue
import com.example.loginapirest.ui.repository.RepositoryUser
import com.example.loginapirest.ui.response.LoginResponse


class LoginModel : ViewModel() {
    var name by mutableStateOf("")
    var password by mutableStateOf("")


    fun onSummit(context : Context) : LoginResponse {
        Log.d("Valores","Valor name:$name, valor Password: $password")
        val repository = RepositoryUser()
        return repository.fetchData(context,name,password);
    }
}