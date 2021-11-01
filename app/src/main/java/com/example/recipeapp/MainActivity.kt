package com.example.recipeapp


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var mmv: MainViewModel

    private lateinit var etTitle: EditText
    private lateinit var etAuther: EditText
    private lateinit var etIngred: EditText
    private lateinit var edInstruc: EditText
    private lateinit var btnSave: Button
    private lateinit var btnView: Button
    private lateinit var tv: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mmv = MainViewModel(application)

        etTitle = findViewById(R.id.etTitle)
        etAuther = findViewById(R.id.etAuther)
        etIngred = findViewById(R.id.etIngred)
        edInstruc = findViewById(R.id.edInstruc)
        btnSave = findViewById(R.id.btnSave)
        btnView = findViewById(R.id.btnView)
        tv = findViewById(R.id.tv)

        updateTv()

        btnSave.setOnClickListener {


            var title = etTitle.text.toString()
            var author = etAuther.text.toString()
            var ingredients = etIngred.text.toString()
            var instructions = edInstruc.text.toString()
            mmv.addR(author, ingredients, instructions, title)
            etTitle.text.clear()
            etAuther.text.clear()
            etIngred.text.clear()
            edInstruc.text.clear()
            updateTv()
        }

        btnView.setOnClickListener {
            intent = Intent(applicationContext, MainActivity2::class.java)
            startActivity(intent)
        }

    }

    fun updateTv(){
        mmv.getR().observe(this){

            var all = " \n"
            for (s in it) {
                all = all + "${s.title} \n By: ${s.author}\n\n"
            }
            tv.text = all


        }
    }


}



