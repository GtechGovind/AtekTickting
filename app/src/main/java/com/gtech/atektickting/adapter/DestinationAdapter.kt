package com.gtech.atektickting.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gtech.atektickting.database.AtekDatabase
import com.gtech.atektickting.database.entity.Station
import com.gtech.atektickting.databinding.RecyclerViewDestintionBinding
import com.gtech.atektickting.util.Key
import com.gtech.atektickting.util.SharedResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DestinationAdapter(
    private val destinations: List<Station>,
    private val listener: ItemSelectListener,
    private val context: Context
) : RecyclerView.Adapter<DestinationAdapter.ViewHolder>() {

    private var resource = SharedResource(context)
    private var fareTableId = 0;
    private var selectedPosition = 0

    inner class ViewHolder(val binding: RecyclerViewDestintionBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RecyclerViewDestintionBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        CoroutineScope(Dispatchers.IO).launch {

            if (destinations[position].id == resource.getIntDataData(Key.STATION_ID)) {
                holder.binding.Destination.isClickable = false
                holder.binding.Destination.isEnabled = false
            } else {
                holder.binding.Destination.isClickable = true
                holder.binding.Destination.isEnabled = true
            }

            val fare = AtekDatabase.getInstance(context).fareDao().getFare(
                resource.getIntDataData(Key.STATION_ID),
                destinations[position].id!!,
                fareTableId
            )

            holder.binding.Destination.text = destinations[position].station_name + "\n" + "₹ " + fare.toString()
            holder.binding.Destination.isChecked = selectedPosition == position

            holder.binding.Destination.setOnClickListener {
                selectedPosition = holder.adapterPosition
                notifyDataSetChanged()
                listener.onItemDataChange()
            }

        }
    }

    override fun getItemCount(): Int {
        return destinations.size
    }

}
