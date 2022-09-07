package com.example.e_commercewatches.domain

import com.example.e_commercewatches.data.entity.watche.Watches
import com.example.e_commercewatches.data.repository.WatchesRepositoryInterface

class AddFavouriteUseCase(private val watchesRepository: WatchesRepositoryInterface) {

    fun addWatchToCart(watch: Watches) {
        watchesRepository.addWatchToCart(watch)
    }
}