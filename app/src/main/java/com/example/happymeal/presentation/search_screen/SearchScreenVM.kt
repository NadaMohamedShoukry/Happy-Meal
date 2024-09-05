package com.example.happymeal.presentation.search_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchScreenVM : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is SearchFragment"
    }
    val text: LiveData<String> = _text
}