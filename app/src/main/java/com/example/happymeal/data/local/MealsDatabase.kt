package com.example.happymeal.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [MealsData ::class , UserData :: class], version = 1, exportSchema = false)
abstract class MealsDatabase : RoomDatabase() {
abstract fun mealsDao() : MealsDAO
abstract fun userDao() : UserDAO
//    abstract fun userFavouriteMealsDao() : UserFavoriteMealsDao
    companion object {
        @Volatile
        private var INSTANCE: MealsDatabase? = null
        fun getDatabase(context: Context): MealsDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    MealsDatabase::class.java,
                    "happy_meal_database"
                )
                    .fallbackToDestructiveMigration()
                    .build().also { INSTANCE = it }
            }
        }
    }

}

