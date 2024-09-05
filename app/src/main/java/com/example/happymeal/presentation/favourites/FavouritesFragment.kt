package com.example.happymeal.presentation.favourites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.happymeal.R
import com.example.happymeal.databinding.FragmentFavouritesBinding
import com.example.happymeal.databinding.FragmentHomeScreenBinding
import com.example.happymeal.presentation.home_screen.HomeScreenVM

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FavouritesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavouritesFragment : Fragment() {
    private var _binding: FragmentFavouritesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val favouritesViewModel= ViewModelProvider(this).get(FavouritesVM :: class.java)
        _binding=FragmentFavouritesBinding.inflate(inflater, container, false)
        val root : View = binding.root

        val textView : TextView = binding.favText
        favouritesViewModel.text.observe(viewLifecycleOwner){
            textView.text=it
        }
        return root
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}