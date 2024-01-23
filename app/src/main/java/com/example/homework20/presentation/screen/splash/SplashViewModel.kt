package com.example.homework20.presentation.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {
    private val _uiEvent = MutableSharedFlow<SplashUiEvent>()
    val uiEvent: SharedFlow<SplashUiEvent> get() = _uiEvent

    init {
        readSession()
    }


    private fun readSession() {
        viewModelScope.launch {
            _uiEvent.emit(SplashUiEvent.NavigateToWelcome)
        }
    }


    sealed interface SplashUiEvent {
        object NavigateToWelcome : SplashUiEvent
    }
}