package com.example.recipeapp.Model

import androidx.room.*
import com.example.recipeapp.Model.Recipe

@Dao
interface RecipeDao {
    @Query("select * from Recipe order by Id Asc")
    fun getR():List<Recipe>
    @Insert
    fun addR(recipe: Recipe)
    @Update
    fun updateR(recipe: Recipe)
    @Delete
    fun deleteR(recipe: Recipe)
}