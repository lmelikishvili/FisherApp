package com.example.homework20.data.repository.fish

import com.example.homework20.data.local.dao.FishDao
import com.example.homework20.data.local.mapper.fish.toDataLayerModel
import com.example.homework20.data.local.mapper.fish.toDomain
import com.example.homework20.data.local.mapper.user.toDomain
import com.example.homework20.domain.model.fish.GetFish
import com.example.homework20.domain.repository.fish.LocalFishRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalFishRepositoryImpl @Inject constructor(
    private val fishDao: FishDao
): LocalFishRepository {
    override fun getAll(): Flow<List<GetFish>> {
        return fishDao.getAll().map { fishs ->
            fishs.map {
                it.toDomain()
            }
        }
    }

    override suspend fun loadAllByIds(fishIds: IntArray): List<GetFish> {
        TODO("Not yet implemented")
    }

    override suspend fun findByName(name: String): GetFish {
        TODO("Not yet implemented")
    }

    override suspend fun insertFish(fish: GetFish) {
        fishDao.insertAll(fish.toDataLayerModel())
    }

    override suspend fun delete(user: GetFish) {
        TODO("Not yet implemented")
    }
}