package com.example.recipeapp


import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.recipeapp.Model.Recipe
import com.example.recipeapp.Model.RecipeDatabase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var etTitle: EditText
    private lateinit var etAuther: EditText
    private lateinit var etIngred: EditText
    private lateinit var edInstruc: EditText
    private lateinit var btnSave: Button
    private lateinit var btnView: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etTitle = findViewById(R.id.etTitle)
        etAuther = findViewById(R.id.etAuther)
        etIngred = findViewById(R.id.etIngred)
        edInstruc = findViewById(R.id.edInstruc)
        btnSave = findViewById(R.id.btnSave)
        btnView = findViewById(R.id.btnView)


        btnSave.setOnClickListener {
            val title = etTitle.text.toString()
            val author = etAuther.text.toString()
            val ingredients = etIngred.text.toString()
            val instructions = edInstruc.text.toString()
            if (title.isNotEmpty() && author.isNotEmpty() && ingredients.isNotEmpty() && instructions.isNotEmpty()) {
                val recipe = Recipe(0, author, ingredients, instructions, title)
                RecipeDatabase.getInstance(applicationContext).RecipeDao().addR(recipe)

            } else {
                Toast.makeText(applicationContext, "please enter all fields", Toast.LENGTH_SHORT)
                    .show()
            }
            etTitle.text.clear()
            etAuther.text.clear()
            etIngred.text.clear()
            edInstruc.text.clear()

        }

        btnView.setOnClickListener {
            intent = Intent(applicationContext, MainActivity2::class.java)
            startActivity(intent)
        }

    }


    }



