package com.gtech.atektickting.fragment.basic

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gtech.atektickting.MainActivity
import com.gtech.atektickting.R
import com.gtech.atektickting.controller.ConfigController
import com.gtech.atektickting.controller.NavBarController
import com.gtech.atektickting.databinding.FragmentConfigureBinding
import com.gtech.atektickting.model.configure.ConfigResponse
import com.gtech.atektickting.repository.ConfigRepository
import com.gtech.atektickting.util.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConfigureFragment : Fragment(), NetworkUi, ControllerService {

    private lateinit var binding: FragmentConfigureBinding
    private lateinit var repository: ConfigRepository
    private lateinit var response: ConfigResponse
    private lateinit var resource: SharedResource

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentConfigureBinding.inflate(layoutInflater, container, false)
        initializeConfigFragment()
        return binding.root
    }

    private fun initializeConfigFragment() {

        NavBarController.setNavContent(
            requireActivity(),
            (this.activity as MainActivity).mainBinding
        )

        repository = ConfigRepository(
            this@ConfigureFragment,
            activity
        )

        resource = SharedResource(
            requireContext()
        )

        binding.Configure.setOnClickListener {
            startConfiguringDevice()
        }

    }

    private fun startConfiguringDevice() {
        CoroutineScope(Dispatchers.IO).launch {
            response = repository.getConfiguration()!!
            activity?.runOnUiThread {
                ConfigController(
                    this@ConfigureFragment
                ).insertDataIntoLocalDatabase(
                    response,
                    requireActivity()
                )
            }
        }
    }

    // UI
    override fun loading(isLoading: Boolean) {
        binding.Configure.isVisible = !isLoading
        binding.ConfigProgressBar.isVisible = isLoading
    }
    override fun onError(message: Enums.ERROR) {
        Log.e("ERROR", message.toString())
    }

    // CONTROLLER
    override fun onStartController() {
        loading(true)
    }
    override fun onFinishController() {
        loading(false)
        resource.saveData(Key.IS_CONFIGURED, true)
        findNavController().navigate(R.id.goToConfigToLogin)
    }
}