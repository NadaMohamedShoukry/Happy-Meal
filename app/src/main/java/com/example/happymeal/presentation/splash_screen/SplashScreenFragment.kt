package com.example.happymeal.presentation.splash_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.happymeal.R
import com.example.happymeal.databinding.FragmentSignupBinding
import com.example.happymeal.databinding.FragmentSplashScreenBinding
import com.example.happymeal.presentation.signup.SignupVM

import androidx.navigation.fragment.navArgs
class SplashScreenFragment : Fragment() {
    private var _binding: FragmentSplashScreenBinding? = null
    private val binding get() = _binding!!
//    private val splashScreenArgs :FragmentSplashScreenArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val splashViewModel= ViewModelProvider(this).get(SplashScreenVM:: class.java)
        _binding= FragmentSplashScreenBinding.inflate(inflater, container, false)
        val root : View = binding.root

        val textView : TextView = binding.splashText
        splashViewModel.text.observe(viewLifecycleOwner){
            textView.text=it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.splashButton.setOnClickListener {
            findNavController().navigate(SplashScreenFragmentDirections.actionSplashFragmentToSignupFragment())
        }
    }
    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
    }

