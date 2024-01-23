package com.example.homework20.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.homework20.data.local.entity.FishEntity
import com.example.homework20.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FishDao {

    @Query("SELECT * FROM fishentity")
    fun getAll(): Flow<List<FishEntity>>

    @Query("SELECT * FROM fishentity WHERE id IN (:fishIds)")
    fun loadAllByIds(fishIds: IntArray): Flow<List<FishEntity>>

    @Query("SELECT * FROM fishentity WHERE name LIKE :name LIMIT 1")
    suspend fun findByName(name: String): FishEntity

    @Insert
    suspend fun insertAll(vararg users: FishEntity)

    @Delete
    suspend fun delete(user: FishEntity)
}