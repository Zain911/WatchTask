package com.example.e_commercewatches.domain

import com.example.e_commercewatches.data.entity.watche.Watches
import com.example.e_commercewatches.data.repository.WatchesRepositoryInterface
import javax.inject.Inject

class CartUseCase @Inject constructor(private val watchesRepository: WatchesRepositoryInterface) {

    fun addWatchToCart(watch: Watches) {
        watchesRepository.addWatchToCart(watch)
    }

    suspend fun getWatches() = watchesRepository.getWatchesFromCart()

    fun updateItem(watch: Watches) {
        watchesRepository.updateItem(watch)
    }
}