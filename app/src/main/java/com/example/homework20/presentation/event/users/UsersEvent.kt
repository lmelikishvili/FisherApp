package com.example.homework20.presentation.event.users

sealed class UsersEvent {
    data class CreateUser(
        val id: Int,
        val firstName: String,
        val lastName: String,
        val age: Int,
        val email: String,
        val password: String
    ) : UsersEvent()
}
