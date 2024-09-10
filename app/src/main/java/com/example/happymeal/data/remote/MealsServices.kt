package com.example.happymeal.data.remote


import com.example.happymeal.data.model.CategoryResponse
import com.example.happymeal.data.model.MealsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsServices {
    @GET("categories.php")
    suspend fun getCategories(): CategoryResponse

    @GET("filter.php?")
    suspend fun getMealsByCategory(
        @Query("c") category: String
    ): MealsResponse

    @GET("lookup.php?")
    suspend fun lookUpById(
        @Query("i") id: String
    ): CategoryResponse

    @GET("search.php?")
    suspend fun searchMealByName(
        @Query("s")name:String
    ):CategoryResponse

//    @GET("list.php?i=list")
//    suspend fun listIngredients(): Response<CategoryResponse>

    @GET("search.php?")
    suspend fun listMealsByFirstLetter(
        @Query("f") letter: Char
    ):  CategoryResponse
}