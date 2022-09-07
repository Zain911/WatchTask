package com.example.e_commercewatches.di

import com.example.e_commercewatches.data.presistentstorage.room.CartDao
import com.example.e_commercewatches.data.repository.WatchesRepository
import com.example.e_commercewatches.data.repository.WatchesRepositoryInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideWatchesRepository(
        cartDao: CartDao,
    ): WatchesRepositoryInterface {
        return WatchesRepository(cartDao)
    }


}