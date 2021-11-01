package com.example.recipeapp
import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.recipeapp.Model.Recipe
import com.example.recipeapp.Model.RecipeDatabase


class MainViewModel (application: Application):AndroidViewModel(application) {
    private val recipes:LiveData<List<Recipe>>
    val app = application

    init {
        recipes = RecipeDatabase.getInstance(app).RecipeDao().getR()
    }
    fun getR():LiveData<List<Recipe>>{
        return recipes
    }
    fun addR(author:String,ingredients:String,instructions:String,title:String){

        if (title.isNotEmpty()&&author.isNotEmpty()&&ingredients.isNotEmpty()&&instructions.isNotEmpty())
        {
            RecipeDatabase.getInstance(app).RecipeDao().addR(Recipe(0,author,ingredients,instructions,title))
            Toast.makeText(app, "recipe is added ", Toast.LENGTH_SHORT).show()
        }
        else
        {
            Toast.makeText(app, "please fill all fields", Toast.LENGTH_SHORT).show()
        }
    }

}