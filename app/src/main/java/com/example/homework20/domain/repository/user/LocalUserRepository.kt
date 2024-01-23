package com.example.homework20.domain.repository.user

import com.example.homework20.domain.model.user.GetUser
import kotlinx.coroutines.flow.Flow

interface LocalUserRepository {
    fun getAll(): Flow<List<GetUser>>
    suspend fun loadAllByIds(userIds: IntArray): List<GetUser>
    suspend fun findByName(first: String, last: String): GetUser
    suspend fun insertUser(user: GetUser)
    suspend fun delete(user: GetUser)
}
