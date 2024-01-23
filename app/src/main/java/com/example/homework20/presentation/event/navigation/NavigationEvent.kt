package com.example.homework20.presentation.event.navigation

sealed class NavigationEvent{
    data object NavigateToLogin: NavigationEvent()
    data object NavigateToRegister: NavigationEvent()
}
