package com.example.happymeal.presentation.home_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeScreenVM : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is HomeFragment"
    }
    val text: LiveData<String> = _text
}