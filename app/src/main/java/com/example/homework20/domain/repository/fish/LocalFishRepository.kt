package com.example.homework20.domain.repository.fish

import com.example.homework20.domain.model.fish.GetFish
import kotlinx.coroutines.flow.Flow

interface LocalFishRepository {
    fun getAll(): Flow<List<GetFish>>
    suspend fun loadAllByIds(fishIds: IntArray): List<GetFish>
    suspend fun findByName(name: String): GetFish
    suspend fun insertFish(fish: GetFish)
    suspend fun delete(user: GetFish)
}