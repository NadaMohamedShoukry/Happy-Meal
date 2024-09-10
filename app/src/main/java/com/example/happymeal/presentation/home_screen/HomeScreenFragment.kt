package com.example.happymeal.presentation.home_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.happymeal.R
import com.example.happymeal.data.local.MealsDAO
import com.example.happymeal.data.local.MealsDatabase
import com.example.happymeal.databinding.FragmentHomeScreenBinding
import com.example.happymeal.domain.repo.MealsRepository

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
    private lateinit var viewModel: HomeScreenVM
    private lateinit var repository: MealsRepository
    private lateinit var mealsDao: MealsDAO
    private lateinit var homeAdapter: HomeAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//      val homeViewModel=ViewModelProvider(this).get(HomeScreenVM :: class.java)
        _binding=FragmentHomeScreenBinding.inflate(inflater, container, false)
       val root : View = binding.root
//
//        val textView : TextView = binding.homeText
//        homeViewModel.text.observe(viewLifecycleOwner){
//            textView.text=it
//        }
        return root
   }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        mealsDao = MealsDatabase.getDatabase(requireContext()).mealsDao()
//        repository =MealsRepository(mealsDao)
//        val viewModelFactory = HomeViewModelFactory(repository)
//        viewModel = ViewModelProvider(this, viewModelFactory)[HomeScreenVM::class.java]
//        binding.recyclerView.layoutManager=GridLayoutManager(requireContext(),2)
//        val adapter = HomeAdapter(emptyList())
//        binding.recyclerView.adapter=adapter
//        viewModel.categories.observe(viewLifecycleOwner){
//            category ->adapter.updateCategories(category)
//        }
//        viewModel.fetchCategories()
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mealsDao = MealsDatabase.getDatabase(requireContext()).mealsDao()
        repository =MealsRepository(mealsDao)
        val viewModelFactory = HomeViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[HomeScreenVM::class.java]
        // Initialize RecyclerView and Adapter

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(),2)
        }
        viewModel.categories.observe(viewLifecycleOwner) { categories ->
            homeAdapter = HomeAdapter(categories) { category ->
                if (category.isFavourite!!) {
                    viewModel.removeCategoryFromFavorites(category)
                } else {
                    viewModel.addCategoryToFavorites(category)
                }
            }
            binding.recyclerView.adapter = homeAdapter
        }
        viewModel.fetchCategories()

    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}