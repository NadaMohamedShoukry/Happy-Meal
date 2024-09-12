package com.example.happymeal.data.local
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

    //Meals Entity
    @Entity(tableName = "categories")
    data class MealsData(
        @PrimaryKey val idCategory: String="",
        val strCategoryDescription: String?="",
        val strCategory: String?="",
        val strCategoryThumb: String?="",
        var isFavourite : Boolean?=false
    )
@Entity(tableName = "mealsListCategories")
data class Meals(
    @PrimaryKey val idMeal: String="",
    val strMeal: String?="",
    val strMealThumb: String?="",
    val idCategory: String="",
    val isFavourite : Boolean?=false
)

    //User Entity
    @Entity(tableName = "user")
    data class UserData(
        @PrimaryKey (autoGenerate = true)
        val userId: Int=0,
        val name: String,
        val email: String,
        val password: String,
        val confirmPassword: String,
    )

//Favourite meals for a user

//@Entity(
//    tableName = "user_favorite_meals",
//    primaryKeys = ["userId", "mealId"],
//    foreignKeys = [
//        ForeignKey(entity = UserData::class, parentColumns = ["userId"], childColumns = ["userId"]),
//        ForeignKey(entity = MealsData::class, parentColumns = ["mealId"], childColumns = ["mealId"])
//    ]
//)
//data class UserFavoriteMeals(
//    val userId: Int,
//    val mealId: Int
//)