package com.example.happymeal.presentation.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.happymeal.domain.repo.MealsRepository

class HomeViewModelFactory( private val repository: MealsRepository) : ViewModelProvider.Factory{
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeScreenVM::class.java)) {
            return HomeScreenVM(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}