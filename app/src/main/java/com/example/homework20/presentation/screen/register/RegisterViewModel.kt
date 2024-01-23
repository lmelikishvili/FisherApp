package com.example.homework20.presentation.screen.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework20.domain.model.user.GetUser
import com.example.homework20.domain.usecase.user.GetUsersUseCase
import com.example.homework20.domain.usecase.user.InsertUserUseCase
import com.example.homework20.presentation.event.users.UsersEvent
import com.example.homework20.presentation.mapper.user.toPresenter
import com.example.homework20.presentation.model.user.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
    private val insertUserUseCase: InsertUserUseCase
) : ViewModel() {

    val users: Flow<List<User>> = getUsersUseCase().map { user ->
        user.map {
            it.toPresenter()
        }
    }

    private val _uiEvent = MutableSharedFlow<LogInUiEvent>()
    val uiEvent: SharedFlow<LogInUiEvent> get() = _uiEvent



    fun onEvent(event: UsersEvent) {
        when (event) {
            is UsersEvent.CreateUser -> insertUser(event.id, event.firstName,event.lastName,event.age,event.email,event.password)
        }
    }

    private fun insertUser(
        id: Int,
        firstName: String,
        lastName: String,
        age: Int,
        email: String,
        password: String) {
        viewModelScope.launch {
            insertUserUseCase(
                user = GetUser(
                    id = id,
                    firstName = firstName,
                    lastName = lastName,
                    age = age,
                    email = email,
                    password = password
                )
            )
            _uiEvent.emit(LogInUiEvent.NavigateToLogin)
        }
    }

    private fun toLogin(){
        viewModelScope.launch {
            _uiEvent.emit(LogInUiEvent.NavigateToLogin)
        }
    }

    sealed interface LogInUiEvent {
        data object NavigateToLogin : LogInUiEvent
    }

}