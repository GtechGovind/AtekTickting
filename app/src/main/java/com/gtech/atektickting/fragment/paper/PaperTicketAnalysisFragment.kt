package com.gtech.atektickting.fragment.paper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gtech.atektickting.adapter.ItemSelectListener
import com.gtech.atektickting.adapter.ProductAdapter
import com.gtech.atektickting.database.AtekDatabase
import com.gtech.atektickting.database.entity.Product
import com.gtech.atektickting.databinding.FragmentPaperTicketBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PaperTicketAnalysisFragment : Fragment(), ItemSelectListener {

    private lateinit var binding: FragmentPaperTicketBinding
    private lateinit var scope: CoroutineScope
    private lateinit var products: List<Product>
    private lateinit var productAdapter: ProductAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
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
            products = AtekDatabase.getInstance(requireContext()).productDao().getProducts()
            productAdapter = ProductAdapter(products, this@PaperTicketAnalysisFragment)
            binding.ProductRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            binding.ProductRecyclerView.adapter = productAdapter
        }
    }

    override fun onItemDataChange() {

    }


}