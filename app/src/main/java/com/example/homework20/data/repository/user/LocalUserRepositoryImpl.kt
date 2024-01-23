package com.example.homework20.data.repository.user

import com.example.homework20.data.local.dao.UserDao
import com.example.homework20.data.local.mapper.user.toDataLayerModel
import com.example.homework20.data.local.mapper.user.toDomain
import com.example.homework20.domain.model.user.GetUser
import com.example.homework20.domain.repository.user.LocalUserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalUserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : LocalUserRepository {
    override fun getAll(): Flow<List<GetUser>> {
        return userDao.getAll().map { users ->
            users.map {
                it.toDomain()
            }
        }
    }

    override suspend fun loadAllByIds(userIds: IntArray): List<GetUser> {
        TODO("Not yet implemented")
    }

    override suspend fun findByName(first: String, last: String): GetUser {
        TODO("Not yet implemented")
    }

    override suspend fun insertUser(user: GetUser) {
        userDao.insertAll(user.toDataLayerModel())
    }


    override suspend fun delete(user: GetUser) {
        TODO("Not yet implemented")
    }

}