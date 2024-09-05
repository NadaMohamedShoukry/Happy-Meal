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
    suspend fun insertMeal(meal: MealsData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMeals(meals: List<MealsData>)

    @Query("SELECT * FROM meals")
    suspend fun getAllMeals(): List<MealsData>

    @Query("SELECT * FROM meals WHERE isFavorite = 1")
    suspend fun getFavoriteMeals(): List<MealsData>

    @Update
    suspend fun updateMeals(meal: MealsData)

    @Delete
    suspend fun deleteMeals(meal: MealsData)

    @Query("DELETE FROM meals WHERE mealId = :mealId")
    suspend fun deleteMealById(mealId: Int)


}
@Dao
interface UserDAO {
    //User
    @Insert(onConflict = OnConflictStrategy.REPLACE)
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