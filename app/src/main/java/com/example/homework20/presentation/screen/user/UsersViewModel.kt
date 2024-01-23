package com.example.homework20.presentation.screen.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework20.domain.model.user.GetUser
import com.example.homework20.domain.usecase.GetUsersUseCase
import com.example.homework20.domain.usecase.InsertUserUseCase
import com.example.homework20.presentation.event.users.UsersEvent
import com.example.homework20.presentation.mapper.user.toPresenter
import com.example.homework20.presentation.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
    private val insertUserUseCase: InsertUserUseCase
) : ViewModel() {

    val users: Flow<List<User>> = getUsersUseCase().map { user ->
        user.map {
            it.toPresenter()
        }
    }


    fun onEvent(event: UsersEvent) {
        when (event) {
            is UsersEvent.CreateUser -> insertUser()
        }
    }

    private fun insertUser() {
        viewModelScope.launch {
            insertUserUseCase(
                user = GetUser(
                    id = Random.nextInt(),
                    firstName = "levana",
                    lastName = "Meliqa",
                    age = 35,
                    email = "Gasa@asd.ge",
                    password = "qweqwe1!"
                )
            )
        }
    }
}