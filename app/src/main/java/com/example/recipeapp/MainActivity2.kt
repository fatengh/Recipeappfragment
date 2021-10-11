package com.example.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.Model.RecipeDatabase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity2 : AppCompatActivity() {
    lateinit var rvRecip: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        rvRecip = findViewById(R.id.rvdata)
        val recipes = RecipeDatabase.getInstance(applicationContext).RecipeDao().getR()
        rvRecip.adapter = RecipeAdap(this@MainActivity2, recipes!!)
        rvRecip.layoutManager = LinearLayoutManager(this@MainActivity2)
    }


}