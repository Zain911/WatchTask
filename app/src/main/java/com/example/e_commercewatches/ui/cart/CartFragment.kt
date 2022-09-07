package com.example.e_commercewatches.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.e_commercewatches.data.entity.watche.Watches
import com.example.e_commercewatches.databinding.FragmentCartBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class CartFragment : Fragment() {
    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CartViewModel by viewModels()

    private lateinit var watchesAdapter: CartAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        val root: View = binding.root

        watchesAdapter = CartAdapter(arrayListOf(), {
            //increase item quantity
            viewModel.increaseItemQuantity(it)
        }) {
            //decrease item quantity
            viewModel.decreaseItemQuantity(it)
        }

        lifecycleScope.launch {
            viewModel.getWatches()
        }

        viewModel.watchesList.observe(viewLifecycleOwner) {
            if (!it.isNullOrEmpty()) {
                watchesAdapter.changeList(it as MutableList<Watches>)
                binding.emptyCartLottieView.visibility = View.GONE
                binding.groupedCart.visibility = View.VISIBLE
            } else {
                binding.emptyCartLottieView.visibility = View.VISIBLE
                binding.groupedCart.visibility = View.GONE
            }
        }

        binding.recyclerView.adapter = watchesAdapter

        viewModel.totalPrice.observe(viewLifecycleOwner) {
            binding.totalValueTextView.text = "$$it"
        }

        binding.backButtonImageView.setOnClickListener { findNavController().navigateUp() }

        return root
    }


}