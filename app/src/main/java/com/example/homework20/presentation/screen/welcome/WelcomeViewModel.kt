package com.example.homework20.presentation.screen.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework20.presentation.event.navigation.NavigationEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch


class WelcomeViewModel: ViewModel() {

    private val _uiEvent = MutableSharedFlow<LogInUiEvent>()
    val uiEvent: SharedFlow<LogInUiEvent> get() = _uiEvent

    fun onEvent(event: NavigationEvent) {
        when (event) {
            is NavigationEvent.NavigateToLogin-> toLogin()
            is NavigationEvent.NavigateToRegister-> toRegister()
        }
    }

    private fun toLogin(){
        viewModelScope.launch {
            _uiEvent.emit(LogInUiEvent.NavigateToLogin)
        }
    }

    private fun toRegister(){
        viewModelScope.launch {
            _uiEvent.emit(LogInUiEvent.NavigateToRegister)
        }
    }

    sealed interface LogInUiEvent {
        data object NavigateToLogin : LogInUiEvent
        data object NavigateToRegister : LogInUiEvent
    }
}