package com.gtech.atektickting.fragment.basic

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gtech.atektickting.R
import com.gtech.atektickting.databinding.FragmentSplashScreenBinding
import com.gtech.atektickting.util.Key
import com.gtech.atektickting.util.SharedResource

@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : Fragment() {

    private lateinit var binding: FragmentSplashScreenBinding
    private lateinit var resource: SharedResource

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSplashScreenBinding.inflate(layoutInflater, container, false)

        // DECLARATIONS
        resource = context?.let { SharedResource(it) }!!

        initTransaction()

        return binding.root
    }

    private fun initTransaction() {

        if (resource.getBoolDataData(Key.IS_CONFIGURED)) {
            findNavController().navigate(R.id.goToSplashToLogin)
        } else {
            findNavController().navigate(R.id.goToSplashToConfig)
        }

    }

}