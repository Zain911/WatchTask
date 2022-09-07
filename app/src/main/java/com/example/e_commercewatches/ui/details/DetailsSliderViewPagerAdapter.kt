package com.example.e_commercewatches.ui.details

import android.app.Dialog
import android.content.Context
import android.view.*
import android.webkit.WebView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_commercewatches.R
import com.google.android.material.imageview.ShapeableImageView


class DetailsSliderViewPagerAdapter(private val imageList: List<String>) :
    RecyclerView.Adapter<DetailsSliderViewPagerAdapter.ImageViewHolder>() {

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val slider = itemView.findViewById<ShapeableImageView>(R.id.sliderImageView)

        fun bind(data: String?) {
            Glide.with(slider)
                .load(data)
                .into(slider)
            slider.setOnClickListener { showZoomableImage(slider.context, data.toString()) }
        }

        private fun showZoomableImage(context: Context, fileUrl: String) {
            val d = Dialog(context, android.R.style.Theme_DeviceDefault_Light_NoActionBar)
            d.window?.setGravity(Gravity.CENTER)
            d.setCancelable(true)
            val wv = WebView(context)
            wv.layoutParams = WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.MATCH_PARENT
            )
            wv.loadUrl(fileUrl)
            wv.settings.builtInZoomControls = true
            wv.settings.setSupportZoom(true)
            wv.settings.loadWithOverviewMode = true
            wv.settings.useWideViewPort = true
            wv.zoomOut()
            d.setContentView(wv)
            d.show()
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