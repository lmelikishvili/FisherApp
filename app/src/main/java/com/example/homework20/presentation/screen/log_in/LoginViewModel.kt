package com.example.homework20.presentation.screen.log_in

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework20.presentation.event.navigation.NavigationEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val _uiEvent = MutableSharedFlow<LoginViewModel.LogInUiEvent>()
    val uiEvent: SharedFlow<LoginViewModel.LogInUiEvent> get() = _uiEvent

    fun onEvent(event: NavigationEvent) {
        when (event) {
            is NavigationEvent.NavigateToFishFragment -> toDashboard()
            else -> {}
        }
    }

    private fun toDashboard(){
        viewModelScope.launch {
            _uiEvent.emit(LogInUiEvent.NavigateToFishFragment)
        }
    }


    sealed interface LogInUiEvent {
        data object NavigateToFishFragment : LogInUiEvent
    }

}