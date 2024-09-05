package com.example.happymeal.presentation.favourites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FavouritesVM : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is FavouriteFragment"
    }
    val text: LiveData<String> = _text
}