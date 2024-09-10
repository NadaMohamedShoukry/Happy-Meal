package com.example.happymeal.presentation.home_screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.happymeal.data.local.MealsData
import com.example.happymeal.data.model.CategoryResponse
import com.example.happymeal.data.remote.MealsModule
import com.example.happymeal.domain.repo.MealsRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeScreenVM ( private val repository: MealsRepository): ViewModel() {
    private val _categories = MutableLiveData<List<MealsData>>()
    val categories: LiveData<List<MealsData>> get() = _categories
    fun fetchCategories() {
        viewModelScope.launch {
            try{
                repository.fetchAndSaveCategoriesWithMeals()
                _categories.value = repository.getAllCategories()
            }catch(e:Exception){
                Log.e("MealsViewModelError",e.message.toString())
            }

        }
    }
    fun addCategoryToFavorites(category: MealsData) {
        viewModelScope.launch {
            repository.addCategoryToFavorites(category)
        }
    }

    fun removeCategoryFromFavorites(category: MealsData) {
        viewModelScope.launch {
            repository.removeCategoryFromFavorites(category)
        }
    }


//init {
//    fetchCategories()
//}
//
//    private fun fetchCategories(){
//        viewModelScope.launch {
//            MealsModule.apiService.getCategories().enqueue(object : Callback<CategoryResponse> {
//                override fun onResponse(
//                    call: Call<CategoryResponse>,
//                    response: Response<CategoryResponse>
//                ) {
//                    _categories.value = response.body()!!.categories
//                }
//
//                override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
//                    Log.d("nada", t.message.toString())
//                }
//
//            })
//        }
 //   }


}