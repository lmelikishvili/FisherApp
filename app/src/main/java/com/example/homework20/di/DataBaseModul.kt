package com.example.homework20.di

import android.content.Context
import androidx.room.Room
import com.example.homework20.data.local.dao.FishDao
import com.example.homework20.data.local.dao.UserDao
import com.example.homework20.data.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataBaseModul {

    @Singleton
    @Provides
    fun provideAppDataBase(@ApplicationContext context: Context): AppDatabase{
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "NewDatabase2"
        ).build()
    }


    @Singleton
    @Provides
    fun provideUserDao(appDatabase: AppDatabase):UserDao{
        return appDatabase.userDao()
    }

    @Singleton
    @Provides
    fun provideFishDao(appDatabase: AppDatabase):FishDao{
        return appDatabase.fishDao()
    }
}