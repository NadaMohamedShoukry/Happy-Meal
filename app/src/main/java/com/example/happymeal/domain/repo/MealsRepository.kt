package com.example.happymeal.domain.repo

import com.example.happymeal.data.local.Meals
import com.example.happymeal.data.local.MealsDAO
import com.example.happymeal.data.local.MealsData
import com.example.happymeal.data.remote.MealsModule.apiService

class MealsRepository(
    private val mealsDAO: MealsDAO,
   // private val apiService: MealsServices
) {
    suspend fun fetchAndSaveCategoriesWithMeals() {
        try {
            // Fetch products from the remote API
            val category = apiService.getCategories()

            // Get the current favorite products from the database
            val favoriteCategories = mealsDAO.getFavoriteMeals()
            val favoriteMap = favoriteCategories.associateBy { it.idCategory }

            // Merge favorite status with fetched products
            val mergedCategories = category.categories.map { category ->
                category.isFavourite = favoriteMap.containsKey(category.idCategory)
                category
            }

            // Save the merged products to the database
            if (mergedCategories.isNotEmpty()) {
                mealsDAO.insertAllCategories(mergedCategories)
            }
        } catch (e: Exception) {
            // Handle exceptions (e.g., logging)
        }
    }
//    // Fetch categories and meals from the API and save them in the database
//    suspend fun fetchAndSaveCategoriesWithMeals() {
//        try {
//            // Fetch categories from the API
//            val categoriesResponse = apiService.getCategories()
//            val categories = categoriesResponse.categories
//           Log.d("categoriesResponse",categoriesResponse.toString())
//            Log.d("categories",categories.toString())
//            // Insert categories in the database
//            mealsDAO.insertAllCategories(categories.map { category ->
//                MealsData(
//                    idCategory = category.idCategory,
//                    strCategoryDescription = category.strCategoryDescription,
//                    strCategory = category.strCategory,
//                    strCategoryThumb = category.strCategoryThumb
//                )
//            })

//            // Fetch and save meals for each category
//            categories.forEach { category ->
//                val mealsResponse = apiService.getMealsByCategory(category.strCategory!!)
//                val meals = mealsResponse.meals
//                Log.d("mealsResponse",mealsResponse.toString())
//                Log.d("meals",meals.toString())
//                // Insert meals for the current category
//                mealsDAO.insertAllMeals(meals.map { meal ->
//                    Meals(
//                        idMeal = meal.idMeal,
//                        strMeal = meal.strMeal,
//                        strMealThumb = meal.strMealThumb,
//                        isFavourite = false, // default to false
//                        idCategory = category.idCategory
//                    )
//                })
//            }
//        } catch (e: Exception) {
//            // Handle any exceptions (e.g., network issues)
//            e.printStackTrace() // Log the exception
//        }
//    }

    // Get all categories from the database
    suspend fun getAllCategories(): List<MealsData> {
        return mealsDAO.getAllCategories()
    }

    // Get meals for a specific category from the database
    suspend fun getMealsByCategory(categoryId: String): List<Meals> {
        return mealsDAO.getMealsByCategory(categoryId)
    }

    // Get favorite meals from the database
    suspend fun getFavoriteMeals(): List<MealsData> {
        return mealsDAO.getFavoriteMeals()
    }
    suspend fun addCategoryToFavorites(category: MealsData) {
        category.isFavourite = true
        mealsDAO.updateCategory(category)
    }
    suspend fun removeCategoryFromFavorites(category: MealsData) {
        category.isFavourite = false
        mealsDAO.updateCategory(category)
    }
    suspend fun deleteCategory(category: MealsData) {
        mealsDAO.deleteCategory(category)
    }

}



