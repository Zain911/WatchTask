package com.example.e_commercewatches.ui.details

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckedTextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commercewatches.R


class ProductDetailsSizeAdapter(
    private val arrayList: ArrayList<String>,
    val clickItem: (String) -> Unit,
) : RecyclerView.Adapter<ProductDetailsSizeAdapter.ViewHolder>() {
    var checkedItemPosition = MutableLiveData(0)
    lateinit var item: String

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product_details_size, parent, false)

        return ViewHolder(view)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.size.isChecked = position == checkedItemPosition.value
        holder.size.text = arrayList[position]
        holder.size.setOnClickListener {
            if (checkedItemPosition.value != position) {
                holder.size.isChecked = true
                checkedItemPosition.value = position
                checkedItemPosition.postValue(position)
                clickItem(arrayList[position])
            }
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val size: CheckedTextView = itemView.findViewById(R.id.item_product_size_checkbox)
    }
}