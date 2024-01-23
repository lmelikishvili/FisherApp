package com.example.homework20.presentation.event.fishs

sealed class FishsEvent{
    data class AddFish(
        val id: Int,
        val name: String,
        val type: String,
        val location: Int,
    ): FishsEvent()
}
