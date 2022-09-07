package com.example.e_commercewatches.data.repository

import androidx.lifecycle.LiveData
import com.example.e_commercewatches.data.entity.watche.Watches
import com.example.e_commercewatches.data.presistentstorage.room.CartDao

class WatchesRepository(private val cartDao: CartDao) : WatchesRepositoryInterface {

    override fun addWatchToCart(watch: Watches) {
        cartDao.addToCart(watch)
    }

    override fun getWatchesFromCart(): LiveData<List<Watches>> = cartDao.getCartProducts()
}