package com.example.loginapirest.ui.remote

import com.example.loginapirest.ui.model.LibroItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiLibro {

    @GET("/api/libro/all")
    suspend fun getAll(): Response<List<LibroItem>>
}