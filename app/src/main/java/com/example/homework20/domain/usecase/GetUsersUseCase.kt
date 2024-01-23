package com.example.homework20.domain.usecase

import com.example.homework20.domain.repository.user.LocalUserRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: LocalUserRepository
) {
    operator fun invoke() =  repository.getAll()
}