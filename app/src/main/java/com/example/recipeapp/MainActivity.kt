package com.example.recipeapp


import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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
            var f = RecipeDeta.recDatum(
                etTitle.text.toString(), etAuther.text.toString(),
                etIngred.text.toString(), edInstruc.text.toString()
            )

            val apiInterface = ApiClient().getClient()?.create(ApiInterface::class.java)

            if (apiInterface != null) {
                apiInterface.addRecipie(f).enqueue(object : Callback<RecipeDeta.recDatum> {
                    override fun onResponse(
                        call: Call<RecipeDeta.recDatum>,
                        response: Response<RecipeDeta.recDatum>
                    ) {

                        etTitle.setText("")
                        etAuther.setText("")
                        etIngred.setText("")
                        edInstruc.setText("")
                        Toast.makeText(applicationContext, "Save Success!", Toast.LENGTH_SHORT).show();
                    }

                    override fun onFailure(call: Call<RecipeDeta.recDatum>, t: Throwable) {
                        etTitle.setText("")
                        etAuther.setText("")
                        etIngred.setText("")
                        edInstruc.setText("")
                        Toast.makeText(applicationContext, "somthing went wrong!", Toast.LENGTH_SHORT).show();

                    }
                })
            }
        }

        btnView.setOnClickListener {
            intent = Intent(applicationContext, MainActivity2::class.java)
            startActivity(intent)
        }

    }


    }



