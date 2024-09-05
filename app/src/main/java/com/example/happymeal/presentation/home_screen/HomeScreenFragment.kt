package com.example.happymeal.presentation.home_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.happymeal.R
import com.example.happymeal.databinding.FragmentHomeScreenBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeScreenFragment : Fragment() {

    private var _binding: FragmentHomeScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val homeViewModel=ViewModelProvider(this).get(HomeScreenVM :: class.java)
        _binding=FragmentHomeScreenBinding.inflate(inflater, container, false)
      val root : View = binding.root

        val textView : TextView = binding.homeText
        homeViewModel.text.observe(viewLifecycleOwner){
            textView.text=it
        }
        return root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}