package com.example.happymeal.presentation.search_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.happymeal.data.local.MealsDAO
import com.example.happymeal.data.local.MealsDatabase
import com.example.happymeal.databinding.FragmentSearchScreenBinding
import com.example.happymeal.domain.repo.MealsRepository

class SearchScreenFragment : Fragment() {
    private var _binding: FragmentSearchScreenBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: SearchScreenVM
    private lateinit var repository: MealsRepository
    private lateinit var mealDao: MealsDAO
    private lateinit var searchAdapter: SearchAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize RecyclerView and Adapter
        searchAdapter = SearchAdapter(emptyList()) // No callback needed here
        binding.recyclerViewSearch.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewSearch.adapter = searchAdapter

        // Initialize database and repository
        mealDao = MealsDatabase.getDatabase(requireContext()).mealsDao()
        repository = MealsRepository(mealDao)

        // Initialize ViewModel with the factory
        val viewModelFactory = SearchViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[SearchScreenVM::class.java]

        // Handle SearchView input
        binding.searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { viewModel.searchMeals(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { viewModel.searchMeals(it) }
                return true
            }
        })

        // Observe search results
        viewModel.categories.observe(viewLifecycleOwner) { categories ->
            searchAdapter.updateList(categories)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
