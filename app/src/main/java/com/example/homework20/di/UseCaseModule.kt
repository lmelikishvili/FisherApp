package com.example.homework20.di

import com.example.homework20.domain.repository.fish.LocalFishRepository
import com.example.homework20.domain.repository.user.LocalUserRepository
import com.example.homework20.domain.usecase.fish.GetFishUseCase
import com.example.homework20.domain.usecase.fish.InsertFishUseCase
import com.example.homework20.domain.usecase.user.GetUsersUseCase
import com.example.homework20.domain.usecase.user.InsertUserUseCase
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

    @Singleton
    @Provides
    fun provideInsertFishUseCase(localFishRepository: LocalFishRepository): InsertFishUseCase {
        return InsertFishUseCase(repository = localFishRepository)
    }

    @Singleton
    @Provides
    fun provideGetFishsUseCase(localFishRepository: LocalFishRepository): GetFishUseCase  {
        return GetFishUseCase(repository = localFishRepository)
    }

}