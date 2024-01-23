package com.example.homework20.presentation.event.Log_in

sealed class LoginEvent{
    data class Login(val email: String, val password: String): LoginEvent()
}
