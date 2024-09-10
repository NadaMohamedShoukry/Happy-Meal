package com.example.happymeal.presentation.splash_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SplashScreenVM :ViewModel(){
    private val _text = MutableLiveData<String>().apply {
        value = "This is Splash Screen Fragment"
    }
    val text: LiveData<String> = _text
}