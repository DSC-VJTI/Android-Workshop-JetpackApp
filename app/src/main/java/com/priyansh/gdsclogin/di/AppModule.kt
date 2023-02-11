package com.priyansh.gdsclogin.di

import com.priyansh.gdsclogin.domain.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun getRepository() : LoginRepository = LoginRepository()

}