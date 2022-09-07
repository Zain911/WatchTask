package com.example.e_commercewatches.ui.home

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.example.e_commercewatches.R
import com.example.e_commercewatches.data.entity.ads.getImage
import com.example.e_commercewatches.data.entity.watche.Watches
import com.example.e_commercewatches.data.entity.watche.getWatches
import com.example.e_commercewatches.databinding.FragmentHomeBinding

import kotlinx.coroutines.*

class HomeFragment : Fragment() {

    private lateinit var productAdapter: ProductAdapter

    private val viewModel: HomeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null
    lateinit var job: Job
    private val binding get() = _binding!!

    private lateinit var viewPager: ViewPager2
    private lateinit var viewPagerAdapter: SliderViewPagerAdapter
    private var dots: Array<TextView?> = arrayOfNulls<TextView>(getImage().size)


    private var onImageSliderChange = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            addDots(position)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        viewPager = binding.adsViewPager
        viewPagerAdapter = SliderViewPagerAdapter(getImage())

        viewPager.apply {
            adapter = viewPagerAdapter
            registerOnPageChangeCallback(onImageSliderChange)
        }

        job = lifecycleScope.launch {
            while (true) for (i in 0..getImage().size) {
                delay(5000)
                if (i == 0) viewPager.setCurrentItem(i, false) else {
                    viewPager.setCurrentItem(i, true)

                }
            }
        }

        productAdapter = ProductAdapter(arrayListOf()) {
            viewModel.navigateToProductDetails(it, binding.root)

        }
        binding.brandsRecyclerView.adapter = productAdapter

      productAdapter.changeList(getWatches() as MutableList<Watches>)


        return root
    }

    private fun addDots(currentImage: Int) {
        binding.linearLayoutDots.removeAllViews()
        for (i in getImage().indices) {
            dots[i] = TextView(context)
            dots[i]?.text = Html.fromHtml("&#8226", Html.FROM_HTML_MODE_LEGACY)
            dots[i]?.textSize = 32f
            dots[i]?.setTextColor(ContextCompat.getColor(requireContext(), R.color.inactive_dots))
            binding.linearLayoutDots.addView(dots[i])
        }
        if (dots.isNotEmpty())
            dots[currentImage]?.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.primary_color
                )
            )


    }

    override fun onPause() {
        super.onPause()
        viewPager.unregisterOnPageChangeCallback(onImageSliderChange)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewPager.unregisterOnPageChangeCallback(onImageSliderChange)
        _binding = null
        job.cancel()
    }
}