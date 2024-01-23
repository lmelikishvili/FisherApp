package com.example.homework20.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey val id: Int,
    val firstName: String,
    val lastName: String,
    val age: Int,
    val email: String,
    val password: String
)