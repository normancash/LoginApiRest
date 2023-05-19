package com.example.loginapirest.ui.remote

import com.example.loginapirest.ui.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiUser {

    @POST("/api/user/login")
    suspend fun getLogin(@Query("name") name: String, @Query("password") password :String): Response<LoginResponse>

    /*@POST("/api/user/save")
    suspend fun saveUser(@Body users : Users) : Response<UsersResponse>*/
}