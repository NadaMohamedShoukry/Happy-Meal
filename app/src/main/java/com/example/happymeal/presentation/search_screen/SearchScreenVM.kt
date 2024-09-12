package com.example.happymeal.presentation.search_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.happymeal.data.local.MealsData
import com.example.happymeal.domain.repo.MealsRepository
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SearchScreenVM ( private val repository: MealsRepository): ViewModel()  {
    private val _categories = MutableLiveData<List<MealsData>>()
    val categories: LiveData<List<MealsData>> get() = _categories
    fun searchMeals(query: String) {
        viewModelScope.launch {
            try {
                // Perform the search using the repository
                val result = repository.searchMeals(query)
                _categories.value = result
            } catch (e: Exception) {
                // Handle errors, e.g., show a toast or log the error
                _categories.value = emptyList()
            }
        }
    }

}