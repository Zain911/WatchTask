package com.example.e_commercewatches.ui.cart

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_commercewatches.R
import com.example.e_commercewatches.data.entity.watche.Watches
import com.example.e_commercewatches.databinding.ItemCartBinding

class CartAdapter(
    private var itemCartList: MutableList<Watches>,
    val increaseItem: (Watches) -> Unit,
    val decreaseItem: (Watches) -> Unit,

    ) :
    RecyclerView.Adapter<CartAdapter.ViewHolder>() {
    private var removedPosition = 0
    lateinit var removedObject: Watches


    @SuppressLint("NotifyDataSetChanged")
    fun changeList(list: MutableList<Watches>) {
        itemCartList.clear()
        itemCartList = list
        notifyDataSetChanged()
    }

    class ViewHolder(var view: ItemCartBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCartBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide
            .with(holder.view.itemCartImage.context)
            .load(itemCartList[position].image)
            .placeholder(R.drawable.placeholder)
            .into(holder.view.itemCartImage)

        holder.view.itemCartTitle.text = itemCartList[position].name
        holder.view.itemCartPrice.text = "$${itemCartList[position].priceAfterSale}"
        holder.view.sizeTextView.text = itemCartList[position].selectedSize
        holder.view.itemCountText.text = itemCartList[position].quantity.toString()

        holder.view.increaseButton.setOnClickListener {

            increaseItem(itemCartList[holder.adapterPosition])
            holder.view.decreaseButton.isEnabled =
                itemCartList[holder.adapterPosition].quantity != 0
        }

        holder.view.decreaseButton.setOnClickListener {
            decreaseItem(itemCartList[holder.adapterPosition])
            holder.view.decreaseButton.isEnabled =
                itemCartList[holder.adapterPosition].quantity != 0
        }
    }


    override fun getItemCount() = itemCartList.size
}