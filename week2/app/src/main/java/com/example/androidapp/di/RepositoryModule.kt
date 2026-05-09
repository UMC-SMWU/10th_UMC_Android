package com.example.androidapp.di

import com.example.androidapp.data.repository.UserRepository
import com.example.androidapp.data.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindTodoRepository(impl: UserRepositoryImpl): UserRepository
}