package com.example.e_commercewatches.ui.details

import androidx.lifecycle.ViewModel
import com.example.e_commercewatches.data.entity.watche.Watches
import com.example.e_commercewatches.domain.AddFavouriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(private val addFavouriteUseCase: AddFavouriteUseCase) :
    ViewModel() {

    fun addToCart(watch: Watches) {
        addFavouriteUseCase.addWatchToCart(watch)
    }


}