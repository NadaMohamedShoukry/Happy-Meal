package com.example.happymeal.presentation.login

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.example.happymeal.databinding.FragmentLoginBinding
import com.example.happymeal.presentation.login.LoginFragmentDirections


class LoginFragment : Fragment() {


    private var _binding : FragmentLoginBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signupTextButton.setOnClickListener {
            // Navigate to the sign-up fragment using the nav graph action
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToSignupFragment())
        }

        // Set up listener for the sign-in button
        binding.signInButton.setOnClickListener {
            val email = binding.emailAddressLogin.text.toString().trim()
            val password = binding.passwordLogin.text.toString().trim()

            if (validateLogin(email, password)) {
                // Handle login logic here
            }

        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun validateLogin(email: String, password: String): Boolean {
        // Email validation
        if (email.isEmpty()) {
            binding.emailAddressLogin.error = "Email is required"
            return false
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.emailAddressLogin.error = "Please enter a valid email address"
            return false
        }

        // Password validation
        if (password.isEmpty()) {
            binding.passwordLogin.error = "Password is required"
            return false
        }
        if (password.length < 6) {
            binding.passwordLogin.error = "Password must be at least 6 characters long"
            return false
        }

        // If all validations pass, return true
        return true
    }

}







