package com.example.loginapirest.ui.viewmodel

import android.database.sqlite.SQLiteBindOrColumnIndexOutOfRangeException
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginapirest.ui.model.LibroItem
import com.example.loginapirest.ui.repository.RepositoryLibro
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LibroViewModel : ViewModel() {
    val libroRepository : RepositoryLibro = RepositoryLibro()

    private val _libroState = MutableStateFlow<UIState>(UIState())
    val libroState: StateFlow<UIState> = _libroState


    init {
        viewModelScope.launch {
            _libroState.update {it.copy(_loading = true)}
            val response =  libroRepository.getAll()
            _libroState.update { it.copy(listLibro=response) }
            _libroState.update {it.copy(_loading = false)}
        }
    }

    data class UIState(
        val _loading: Boolean = false,
        val listLibro: List<LibroItem> = emptyList()
    )
}