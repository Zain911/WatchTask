package com.example.e_commercewatches.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.e_commercewatches.data.entity.watche.Watches
import com.example.e_commercewatches.domain.CartUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(private val cartUseCase: CartUseCase) : ViewModel() {


    val totalPrice = MutableLiveData<Int>()


    private val _watchesList = MutableLiveData<List<Watches>>()
    val watchesList: LiveData<List<Watches>> = _watchesList


    private val breedsObserver = Observer<List<Watches>> {
        _watchesList.postValue(it)
        var price = 0
        for (watch in it) {
            price += watch.priceAfterSale?.toInt()?.times(watch.quantity) ?: 0
        }
        totalPrice.postValue(price)
    }

    suspend fun getWatches() {
        cartUseCase.getWatches().observeForever(breedsObserver)
    }

    fun increaseItemQuantity(watches: Watches) {
        cartUseCase.updateItem(watches.apply {
            this.quantity += 1
        })
    }

    fun decreaseItemQuantity(watches: Watches) {
        cartUseCase.updateItem(watches.apply {
            this.quantity -= 1
        })
    }


}


