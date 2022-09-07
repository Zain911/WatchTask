package com.example.e_commercewatches.data.repository

import androidx.lifecycle.LiveData
import com.example.e_commercewatches.data.entity.watche.Watches

interface WatchesRepositoryInterface {

    fun addWatchToCart(watch: Watches)
    fun getWatchesFromCart(): LiveData<List<Watches>>

}
