package com.example.e_commercewatches.ui.home

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.e_commercewatches.data.entity.watche.Watches


class HomeViewModel : ViewModel() {


    fun navigateToProductDetails(it: Watches, view: View) {
        val nav = Navigation.findNavController(view)
        val action = HomeFragmentDirections.actionNavigationHomeToProductDetailsFragment(it)
        nav.navigate(action)
    }



}


