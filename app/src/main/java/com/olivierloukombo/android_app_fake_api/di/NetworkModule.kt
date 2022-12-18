package com.olivierloukombo.android_app_fake_api.di

import com.olivierloukombo.android_app_fake_api.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideApiService(): ApiService{
        return ApiService.getInstance()
    }
}