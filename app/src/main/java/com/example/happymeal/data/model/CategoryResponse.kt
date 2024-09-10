package com.example.happymeal.data.model


import com.example.happymeal.data.local.Meals
import com.example.happymeal.data.local.MealsData
import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("categories")
    val categories: List<MealsData>
)

data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
)

data class MealsResponse(
    @SerializedName("meal")
    val meals: List<Meals>
)

data class Meal(
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String
)