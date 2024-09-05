package com.example.happymeal.presentation.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileVM : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is ProfileFragment"
    }
    val text: LiveData<String> = _text
}