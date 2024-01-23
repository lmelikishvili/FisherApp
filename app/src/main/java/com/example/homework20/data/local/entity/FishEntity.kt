package com.example.homework20.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FishEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val type: String,
    val location: Int,
)