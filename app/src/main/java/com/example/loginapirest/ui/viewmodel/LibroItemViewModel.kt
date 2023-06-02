package com.example.loginapirest.ui.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginapirest.ui.model.DtoLibro
import com.example.loginapirest.ui.model.LibroItem
import com.example.loginapirest.ui.repository.RepositoryLibro
import com.example.loginapirest.ui.repository.RepositoryUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LibroItemViewModel : ViewModel() {

    var _state = MutableStateFlow(false)
    val state : StateFlow<Boolean> = _state

    /*

    var _state = MutableStateFlow(UIState())
    val state : StateFlow<UIState> = _state.asStateFlow()
     */


   val repository = RepositoryLibro()

   fun addLibro(item : DtoLibro) {
        viewModelScope.launch {
            repository.addLibro(item)
            _state.update {true}
        }

       /*
        viewModelScope.launch {
            _state.update { it.copy(_loading = true) }
            val login = repository.fetchData(name,password).getOrDefault(LoginResponse())
            _state.update{it.copy(loginResponse = login)}
            _state.update { it.copy(_loading = false) }
        }
        */
   }

}