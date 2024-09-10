package com.example.happymeal.presentation.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignupVM :ViewModel(){
    private val _text = MutableLiveData<String>().apply {
        value = "This is Sign up Fragment"
    }
    val text: LiveData<String> = _text
}