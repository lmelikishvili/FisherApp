package com.example.homework20.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.homework20.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM userentity")
    fun getAll(): Flow<List<UserEntity>>

    @Query("SELECT * FROM userentity WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): Flow<List<UserEntity>>

    @Query("SELECT * FROM userentity WHERE firstName LIKE :first AND " +
            "lastName LIKE :last LIMIT 1")
    suspend fun findByName(first: String, last: String): UserEntity

    @Insert
    suspend fun insertAll(vararg users: UserEntity)

    @Delete
    suspend fun delete(user: UserEntity)
}