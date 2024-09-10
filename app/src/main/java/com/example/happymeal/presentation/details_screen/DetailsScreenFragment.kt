package com.example.happymeal.presentation.details_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.happymeal.R
import com.example.happymeal.databinding.FragmentDetailsScreenBinding
import com.example.happymeal.databinding.FragmentFavouritesBinding
import com.example.happymeal.databinding.FragmentSplashScreenBinding
import com.example.happymeal.presentation.splash_screen.SplashScreenVM

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailsScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailsScreenFragment : Fragment() {
    private var _binding: FragmentDetailsScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val detailsViewModel= ViewModelProvider(this).get(DetailsScreenVM:: class.java)
        _binding= FragmentDetailsScreenBinding.inflate(inflater, container, false)
        val root : View = binding.root

        val textView : TextView = binding.detailsText
        detailsViewModel.text.observe(viewLifecycleOwner){
            textView.text=it
        }
        return root
    }


}