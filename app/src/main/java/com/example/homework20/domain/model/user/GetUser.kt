package com.example.homework20.domain.model.user

data class GetUser(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val age: Int,
    val email: String,
    val password: String
)
