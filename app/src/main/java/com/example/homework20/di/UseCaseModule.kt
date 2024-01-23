package com.example.homework20.di

import com.example.homework20.data.local.dao.UserDao
import com.example.homework20.data.repository.LocalUserRepositoryImpl
import com.example.homework20.domain.repository.user.LocalUserRepository
import com.example.homework20.domain.usecase.GetUsersUseCase
import com.example.homework20.domain.usecase.InsertUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object UseCaseModule {

    @Singleton
    @Provides
    fun provideInsertUseCase(localUserRepository: LocalUserRepository): InsertUserUseCase {
        return InsertUserUseCase(repository = localUserRepository)
    }

    @Singleton
    @Provides
    fun provideGetUsersUseCase(localUserRepository: LocalUserRepository): GetUsersUseCase {
        return GetUsersUseCase(repository = localUserRepository)
    }

}