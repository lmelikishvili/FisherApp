package com.example.homework20.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.homework20.data.local.dao.FishDao
import com.example.homework20.data.local.dao.UserDao
import com.example.homework20.data.local.entity.FishEntity
import com.example.homework20.data.local.entity.UserEntity

@Database(entities = [UserEntity::class, FishEntity::class], version = 1)
//@Database(entities = [FishEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun fishDao(): FishDao
}