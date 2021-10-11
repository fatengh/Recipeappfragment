package com.example.recipeapp.Model

import androidx.room.*
@Entity(tableName = "Recipe")
data class Recipe(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "Id") val id: Int= 0,
    @ColumnInfo(name = "Author") val author: String,
    @ColumnInfo(name = "Ingredients") val ingredients: String,
    @ColumnInfo(name = "Instructions") val instructions: String,
    @ColumnInfo(name = "Title") val title: String

)