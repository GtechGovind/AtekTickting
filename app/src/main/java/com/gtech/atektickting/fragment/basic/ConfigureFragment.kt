package com.gtech.atektickting.fragment.basic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gtech.atektickting.databinding.FragmentConfigureBinding
import com.gtech.atektickting.util.Enums
import com.gtech.atektickting.util.NetworkState

class ConfigureFragment : Fragment(), NetworkState {

    private lateinit var binding: FragmentConfigureBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentConfigureBinding.inflate(layoutInflater, container, false)
        initializeConfigFragment()
        return binding.root
    }

    private fun initializeConfigFragment() {

    }

    override fun loading(isLoading: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onError(message: Enums.ERROR) {
        TODO("Not yet implemented")
    }

}