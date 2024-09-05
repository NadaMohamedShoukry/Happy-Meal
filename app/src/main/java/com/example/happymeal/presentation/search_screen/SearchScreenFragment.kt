package com.example.happymeal.presentation.search_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.happymeal.R
import com.example.happymeal.databinding.FragmentProfileBinding
import com.example.happymeal.databinding.FragmentSearchScreenBinding
import com.example.happymeal.presentation.profile.ProfileVM

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchScreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchScreenFragment : Fragment() {
    private var _binding: FragmentSearchScreenBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val searchViewModel= ViewModelProvider(this).get(SearchScreenVM:: class.java)
        _binding= FragmentSearchScreenBinding.inflate(inflater, container, false)
        val root : View = binding.root

        val textView : TextView = binding.searchText
        searchViewModel.text.observe(viewLifecycleOwner){
            textView.text=it
        }
        return root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}