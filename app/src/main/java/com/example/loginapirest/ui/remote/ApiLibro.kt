package com.example.loginapirest.ui.remote

import com.example.loginapirest.ui.model.LibroItem
import com.example.loginapirest.ui.model.LibroResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiLibro {

    @GET("/api/libro/all")
    suspend fun getAll(): List<LibroItem>
}