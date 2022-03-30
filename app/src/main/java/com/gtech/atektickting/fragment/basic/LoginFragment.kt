package com.gtech.atektickting.fragment.basic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gtech.atektickting.MainActivity
import com.gtech.atektickting.R
import com.gtech.atektickting.controller.NavBarController
import com.gtech.atektickting.database.AtekDatabase
import com.gtech.atektickting.database.entity.User
import com.gtech.atektickting.databinding.FragmentLoginBinding
import com.gtech.atektickting.util.Key
import com.gtech.atektickting.util.SharedResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var resource: SharedResource
    private var user: User? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        initializeLoginFragment()
        return binding.root
    }

    private fun initializeLoginFragment() {

        NavBarController.setNavContent(
            requireActivity(),
            (this.activity as MainActivity).mainBinding
        )

        resource = SharedResource(requireContext())

        binding.loginUser.setOnClickListener {
            loginUser()
        }

    }

    private fun loginUser() {

        val userName = binding.Username.text.toString().trim()
        val password = binding.Password.text.toString().trim()

        if (isValidUser(userName, password)) {
            getUserDetails(userName, password)
        }

    }

    private fun getUserDetails(userName: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            user = AtekDatabase
                .getInstance(requireContext())
                .userDao()
                .getUser(userName)
            checkUser(password, user)
        }
    }

    private fun checkUser(password: String, user: User?) {
        when {
            user == null -> activity?.runOnUiThread {
                binding.UsernameLayout.error = "User not found !"
            }
            password != user.password -> activity?.runOnUiThread {
                binding.PasswordLayout.error = "Incorrect password ?"
            }
            else -> activity?.runOnUiThread {
                createUserSession(user)
            }
        }
    }

    private fun createUserSession(user: User) {

        resource.saveData(Key.USER_NAME, user.user_name)
        resource.saveData(Key.USER_ID, user.user_id)
        resource.saveData(Key.PHONE, user.phone)
        resource.saveData(Key.EMAIL, user.email)
        resource.saveData(Key.OPERATOR_ID, user.operator_id)
        resource.saveData(Key.IS_LOGIN, true)

        findNavController().navigate(R.id.goToLoginToPaperTicket)

    }

    private fun isValidUser(userName: String, password: String): Boolean {

        if (userName.isEmpty()) {
            binding.UsernameLayout.error = "Enter Username ?"
            return false
        }

        if (password.isEmpty()) {
            binding.PasswordLayout.error = "Enter Password ?"
            return false
        }

        return true

    }
}