package com.gtech.atektickting.fragment.paper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gtech.atektickting.adapter.DestinationAdapter
import com.gtech.atektickting.adapter.ItemSelectListener
import com.gtech.atektickting.adapter.ProductAdapter
import com.gtech.atektickting.adapter.QuantityAdapter
import com.gtech.atektickting.database.AtekDatabase
import com.gtech.atektickting.database.entity.Product
import com.gtech.atektickting.database.entity.Station
import com.gtech.atektickting.databinding.FragmentPaperTicketBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PaperTicketFragment : Fragment(), ItemSelectListener {

    private lateinit var binding: FragmentPaperTicketBinding
    private lateinit var scope: CoroutineScope

    // ADAPTER DATA
    private lateinit var destinations: List<Station>
    private lateinit var products: List<Product>

    // ADAPTER
    private lateinit var productAdapter: ProductAdapter
    private lateinit var destinationAdapter: DestinationAdapter
    private lateinit var quantityAdapter: QuantityAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPaperTicketBinding.inflate(layoutInflater, container, false)
        initializePaperTicketFragment()
        return binding.root
    }

    private fun initializePaperTicketFragment() {
        scope = CoroutineScope(Dispatchers.Main)
        setAdapters()
    }

    private fun setAdapters() {
        scope.launch {

            // PRODUCT
            products = AtekDatabase.getInstance(requireContext()).productDao().getProducts()
            productAdapter = ProductAdapter(products, this@PaperTicketFragment)
            binding.ProductRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            binding.ProductRecyclerView.adapter = productAdapter

            // DESTINATION
            destinations = AtekDatabase.getInstance(requireContext()).stationDao().getAllStations()
            destinationAdapter = DestinationAdapter(destinations, this@PaperTicketFragment, requireContext())
            /*val gridLayoutManager = GridLayoutManager(context, 6)
            gridLayoutManager.orientation = RecyclerView.HORIZONTAL*/
            binding.DestinationRecyclerView.layoutManager = GridLayoutManager(context, 6)
            binding.DestinationRecyclerView.adapter = destinationAdapter

        }
    }

    override fun onItemDataChange() {

    }

}