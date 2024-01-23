package com.example.homework20.domain.usecase.fish

import com.example.homework20.domain.repository.fish.LocalFishRepository
import javax.inject.Inject

class GetFishUseCase @Inject constructor(
    private val repository: LocalFishRepository
) {
    operator fun invoke() = repository.getAll()
}