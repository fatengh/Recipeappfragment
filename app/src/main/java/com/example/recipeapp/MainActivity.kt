package com.example.recipeapp


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation


class MainActivity : AppCompatActivity() {
    private lateinit var navctrl: NavController



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navctrl = Navigation.findNavController(this, R.id.mainFrag)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navctrl.navigateUp()
    }
}