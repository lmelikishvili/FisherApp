package com.example.homework20.di

import com.example.homework20.data.local.dao.UserDao
import com.example.homework20.data.repository.LocalUserRepositoryImpl
import com.example.homework20.domain.repository.user.LocalUserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideLocalUserRepo(userDao: UserDao): LocalUserRepository{
        return LocalUserRepositoryImpl(userDao = userDao)
    }
}