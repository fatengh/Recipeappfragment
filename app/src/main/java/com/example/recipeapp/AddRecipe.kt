package com.example.recipeapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController


class AddRecipe : Fragment() {

    lateinit var mmv: MainViewModel

    private lateinit var etTitle: EditText
    private lateinit var etAuther: EditText
    private lateinit var etIngred: EditText
    private lateinit var edInstruc: EditText
    private lateinit var btnSave: Button
    private lateinit var btnView: Button
    private lateinit var tv: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_recipe, container, false)
        mmv = ViewModelProvider(this).get(MainViewModel::class.java)

        etTitle = view.findViewById(R.id.etTitle)
        etAuther = view.findViewById(R.id.etAuther)
        etIngred = view.findViewById(R.id.etIngred)
        edInstruc = view.findViewById(R.id.edInstruc)
        btnSave = view.findViewById(R.id.btnSave)
        btnView = view.findViewById(R.id.btnView)
        tv = view.findViewById(R.id.tv)

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
            findNavController().navigate(R.id.action_addRecipe_to_listRecipe)
        }


        return view
    }

    fun updateTv() {
        mmv.getR().observe(viewLifecycleOwner, {

            var all = " \n"
            for (s in it) {
                all = all + "${s.title} \n By: ${s.author}\n\n"
            }
            tv.text = all

        })
    }


}