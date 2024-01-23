package com.example.homework20.domain.usecase.user

import com.example.homework20.domain.model.user.GetUser
import com.example.homework20.domain.repository.user.LocalUserRepository
import javax.inject.Inject

class InsertUserUseCase @Inject constructor(
    private val repository: LocalUserRepository
) {
    suspend operator fun invoke(user: GetUser){
        repository.insertUser(user = user)
    }
}