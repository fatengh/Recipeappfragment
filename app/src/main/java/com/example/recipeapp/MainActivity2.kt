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
    lateinit var mmv: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        mmv= MainViewModel(application)
        rvRecip = findViewById(R.id.rvdata)
        mmv.getR().observe(this){
            rvRecip.adapter = RecipeAdap(this@MainActivity2, it)
            rvRecip.layoutManager = LinearLayoutManager(this@MainActivity2)
        }

    }


}