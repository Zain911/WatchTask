package com.example.e_commercewatches.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commercewatches.R
import com.google.android.material.imageview.ShapeableImageView


class SliderViewPagerAdapter(private val imageList: List<Int>) :
    RecyclerView.Adapter<SliderViewPagerAdapter.ImageViewHolder>() {

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val slider = itemView.findViewById<ShapeableImageView>(R.id.sliderImageView)
        fun bind(data: Int) {
           slider.setImageResource(data)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.slider_item, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(imageList[position])

    }

    override fun getItemCount(): Int {
      return  imageList.size
    }
}