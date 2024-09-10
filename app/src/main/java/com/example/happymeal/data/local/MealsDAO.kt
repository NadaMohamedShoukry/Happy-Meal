package com.example.happymeal.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
@Dao
interface MealsDAO {

    //Meals
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(meal: MealsData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCategories(meals: List<MealsData>)

    @Query("SELECT * FROM categories")
    suspend fun getAllCategories(): List<MealsData>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeals(meal: Meals)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMeals(meals: List<Meals>)

    @Query("SELECT * FROM mealsListCategories WHERE idCategory = :categoryId")
    suspend fun getMealsByCategory(categoryId: String): List<Meals>


    @Query("SELECT * FROM mealsListCategories WHERE isFavourite = 1")
    suspend fun getFavoriteMeals(): List<MealsData>

    @Update
    suspend fun updateCategory(mealData: MealsData)

    @Delete
    suspend fun deleteCategory(meal: MealsData)

    @Query("DELETE FROM mealsListCategories WHERE idCategory = :idCategory")
    suspend fun deleteMealById(idCategory: String)

}
@Dao
interface UserDAO {
    //User
    @Insert()
    suspend fun insertUser(user: UserData)

    @Query("SELECT * FROM user WHERE email = :email AND password = :password")
    suspend fun getUser(email: String, password: String): UserData?

    @Query("SELECT * FROM user WHERE userId = :userId")
    suspend fun getUserById(userId: Int): UserData?

    @Delete
    suspend fun deleteUser(user: UserData)
}


//@Dao
//interface UserFavoriteMealsDao {
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun addFavoriteMeal(userMeals: UserFavoriteMeals)
//
//    @Delete
//    suspend fun removeFavoriteMeal(userMeals: UserFavoriteMeals)
//
////    @Query("SELECT * FROM meals INNER JOIN user_favorite_meals ON meals.mealId = user_favorite_meals.mealId WHERE user_favorite_meals.userId = :userId")
////    suspend fun getFavoriteMealsForUser(userId: Int): List<MealsData>
//}