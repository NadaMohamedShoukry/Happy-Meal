package com.example.happymeal.presentation.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.happymeal.R
import com.example.happymeal.databinding.FragmentFavouritesBinding
import com.example.happymeal.databinding.FragmentLoginBinding
import com.example.happymeal.databinding.FragmentSignupBinding
import com.example.happymeal.presentation.main.MainActivity2
import com.example.happymeal.presentation.signup.SignupVM

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    lateinit var navController: NavController
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val loginViewModel= ViewModelProvider(this).get(LoginVM:: class.java)
        _binding= FragmentLoginBinding.inflate(inflater, container, false)

        val root : View = binding.root

        val textView : TextView = binding.loginText
        loginViewModel.text.observe(viewLifecycleOwner){
            textView.text=it
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()

        // Handle login button click
        binding.loginButton.setOnClickListener {
            // Perform login logic here (e.g., API call)

            // If login successful, navigate to HomeActivity
            (activity as MainActivity2).navigateToHome()
        }

        // Navigate to SignupFragment if user doesn't have an account
//        binding.signupText.setOnClickListener {
//            navController.navigate(R.id.action_loginFragment_to_signupFragment)
//        }
    }
    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}