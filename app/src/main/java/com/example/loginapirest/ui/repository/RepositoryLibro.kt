package com.example.loginapirest.ui.repository

import android.util.Log
import com.example.loginapirest.ui.model.DtoLibro
import com.example.loginapirest.ui.model.LibroItem
import com.example.loginapirest.ui.remote.ApiAdapter
import com.example.loginapirest.ui.remote.ApiLibro
import retrofit2.Response


class RepositoryLibro( ) {

    private val apiLibro : ApiLibro = ApiAdapter.getInstance()
        .create(ApiLibro::class.java)

    suspend fun getAll() : List<LibroItem> {
        try {
            val listLibro = apiLibro.getAll()
            return listLibro
        } catch (e : Exception) {
            Log.d("ERROR",e.message.toString());
        }
        return emptyList<LibroItem>()
    }

    suspend fun addLibro(item : DtoLibro)   {
        try
        {
           apiLibro.save(item)
        } catch (e : Exception) {
            Log.d("ERROR",e.message.toString())
        }
    }


}