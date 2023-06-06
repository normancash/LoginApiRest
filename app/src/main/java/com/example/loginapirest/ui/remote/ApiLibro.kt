package com.example.loginapirest.ui.remote

import com.example.loginapirest.ui.model.DtoLibro
import com.example.loginapirest.ui.model.LibroItem
import com.example.loginapirest.ui.model.LibroResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface ApiLibro {
    @GET("/api/libro/all")
    suspend fun getAll(): List<LibroItem>

    @POST("/api/libro/save/")
    suspend fun save(@Body item : DtoLibro)

    @DELETE("/api/libro/{id}")
    suspend fun delete(@Path("id") id :String)
}