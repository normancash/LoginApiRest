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
    /*var _state = MutableStateFlow(UIState())
    var state : StateFlow<UIState> = _state.asStateFlow()*/
    private val _libroState = MutableStateFlow<List<LibroItem>>(emptyList())
    val libroState: StateFlow<List<LibroItem>> = _libroState


    init {
        viewModelScope.launch {
            val response =  libroRepository.getAll()
            _libroState.value = response
            /*_state.update { it.copy(_loading = true) }
            libroRepository.getAll()
                .onSuccess {
                    _state.update {
                        it.copy(listLibro = it.listLibro)
                    }
                }.
                onFailure {
                    println()
                }
            _state.update { it.copy(_loading = false) }*/
        }
    }

    data class UIState(
        val _loading: Boolean = false,
        val listLibro: List<LibroItem> = emptyList()
    )
}