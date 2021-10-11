package com.example.recipeapp.Model

import android.content.Context
import androidx.room.*

@Database(entities = [Recipe::class],version = 1,exportSchema = false)
abstract class RecipeDatabase :RoomDatabase(){
    companion object{
        var instance: RecipeDatabase?=null
        fun getInstance(context: Context): RecipeDatabase
        {
            if (instance !=null){
                return instance as RecipeDatabase
            }
            instance =Room.databaseBuilder(context, RecipeDatabase::class.java,"Recipe").run { allowMainThreadQueries()}.build()
            return instance as RecipeDatabase
        }
    }
    abstract fun RecipeDao(): RecipeDao
}