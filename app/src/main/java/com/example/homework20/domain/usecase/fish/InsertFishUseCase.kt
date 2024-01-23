package com.example.homework20.domain.usecase.fish

import com.example.homework20.domain.model.fish.GetFish
import com.example.homework20.domain.repository.fish.LocalFishRepository
import javax.inject.Inject

class InsertFishUseCase @Inject constructor(
    private val repository: LocalFishRepository
) {
    suspend operator fun invoke(fish: GetFish){
        repository.insertFish(fish = fish)
    }
}