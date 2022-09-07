package com.example.e_commercewatches.ui.details

import androidx.lifecycle.ViewModel
import com.example.e_commercewatches.data.entity.watche.Watches
import com.example.e_commercewatches.domain.CartUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(private val cartUseCase: CartUseCase) :
    ViewModel() {

    fun addToCart(watch: Watches) {
        cartUseCase.addWatchToCart(watch)
    }

}