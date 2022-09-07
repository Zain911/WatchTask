package com.example.e_commercewatches.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_commercewatches.R

import com.example.e_commercewatches.data.entity.watche.Watches
import com.example.e_commercewatches.databinding.ItemBrandsBinding

class ProductAdapter(
    var vendorList: MutableList<Watches>,
    private val onVendorClicked: (Watches) -> Unit,
) :
    RecyclerView.Adapter<ProductAdapter.VendorViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun changeList(list: MutableList<Watches>) {
        vendorList.clear()
        vendorList = list
        notifyDataSetChanged()
    }

    class VendorViewHolder(var view: ItemBrandsBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VendorViewHolder {
        val binding =
            ItemBrandsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return VendorViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: VendorViewHolder, position: Int) {
        val item = vendorList[position]
        Glide.with(holder.view.brandImageView.context)
            .load(vendorList[position].image)
            .placeholder(R.drawable.watch1)
            .into(holder.view.brandImageView)

        holder.view.brandNameTextView.text = vendorList[position].name
        holder.view.priceBeforeSaleTextView.text= "$${vendorList[position].priceBeforeSale}"
        holder.view.priceAfterSaleTextView.text="$${vendorList[position].priceAfterSale}"
        holder.view.salePercentTextView.text=vendorList[position].percentSale
        holder.view.root.setOnClickListener { onVendorClicked(item) }
    }

    override fun getItemCount() =
        vendorList.size

}