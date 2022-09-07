package com.example.e_commercewatches.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.e_commercewatches.data.entity.watche.Watches
import com.example.e_commercewatches.data.entity.watche.sizeNumber
import com.example.e_commercewatches.databinding.FragmentProductDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailsFragment : Fragment() {
    private val viewModel: ProductDetailsViewModel by viewModels()
    private var _binding: FragmentProductDetailsBinding? = null
    private val args: ProductDetailsFragmentArgs by navArgs()
    private val binding get() = _binding!!
    private lateinit var detailsSizeAdapter: ProductDetailsSizeAdapter
    private lateinit var selectedSizeFromUser: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentProductDetailsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        setUI(args.watchesModel)

        selectedSizeFromUser = sizeNumber[0]

        detailsSizeAdapter = ProductDetailsSizeAdapter(sizeNumber) {
            selectedSizeFromUser = it
        }
        binding.backButtonImageView.setOnClickListener { findNavController().navigateUp() }
        binding.productSizeRecycler.adapter = detailsSizeAdapter

        binding.addToCartButton.setOnClickListener {
            viewModel.addToCart(args.watchesModel.apply {
                this.selectedSize = selectedSizeFromUser
            })
        }
        return root
    }

    private fun setUI(productDetails: Watches) {
        binding.brandNameTextView.text = productDetails.name
        binding.priceAfterSaleTextView.text = productDetails.priceAfterSale
        binding.priceBeforeSaleTextView.text = productDetails.priceBeforeSale
        binding.descriptionTextView.text = productDetails.Description
        binding.ratingBar.rating = productDetails.rating
        binding.productImageView.setImageResource(productDetails.image)
    }


}