package com.example.happymeal.presentation.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.happymeal.R
import com.example.happymeal.databinding.FragmentSearchScreenBinding
import com.example.happymeal.databinding.FragmentSignupBinding
import com.example.happymeal.presentation.main.MainActivity
import com.example.happymeal.presentation.main.MainActivity2
import com.example.happymeal.presentation.search_screen.SearchScreenVM

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignupFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignupFragment : Fragment() {
    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!
    lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val signupViewModel= ViewModelProvider(this).get(SignupVM:: class.java)
        _binding= FragmentSignupBinding.inflate(inflater, container, false)
        val root : View = binding.root

        val textView : TextView = binding.signupText
        signupViewModel.text.observe(viewLifecycleOwner){
            textView.text=it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()

        // Handle signup button click
        binding.signupButton.setOnClickListener {
            // Perform signup logic here (e.g., API call)

            // If signup successful, navigate to HomeActivity
            (activity as MainActivity2).navigateToHome()
        }

        // Navigate back to LoginFragment if the user already has an account
//        binding.loginText.setOnClickListener {
//            navController.navigateUp()
//        }
    }
    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
    }


