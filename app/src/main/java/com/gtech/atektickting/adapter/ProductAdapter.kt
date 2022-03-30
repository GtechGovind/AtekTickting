package com.gtech.atektickting.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gtech.atektickting.database.entity.Product
import com.gtech.atektickting.databinding.RecyclerViewProductBinding

class ProductAdapter(
    private val products: List<Product>,
    private val listener: ItemSelectListener
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private var selectedPosition = 0

    inner class ViewHolder(val binding: RecyclerViewProductBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: RecyclerViewProductBinding =
            RecyclerViewProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.ProductName.text =
            products[position].description.split(" ").toTypedArray()[0]
        holder.binding.ProductName.isChecked = selectedPosition == position
        holder.binding.ProductName.setOnClickListener {

            if (selectedPosition >= 0) notifyItemChanged(selectedPosition)

            selectedPosition = holder.adapterPosition

            notifyDataSetChanged()

            listener.onItemDataChange()

        }
    }

    override fun getItemCount(): Int {
        return products.size
    }
}