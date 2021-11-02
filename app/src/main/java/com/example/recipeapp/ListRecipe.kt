package com.example.recipeapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.Model.Recipe


class ListRecipe : Fragment() {
    lateinit var rvRecip: RecyclerView
    lateinit var mmv: MainViewModel
    private lateinit var myAdap: RecipeAdap
    private lateinit var recipes: List<Recipe>



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_list_recipe, container, false)

        recipes = arrayListOf()

        mmv = ViewModelProvider(this).get(MainViewModel::class.java)
        rvRecip = view.findViewById(R.id.rvdata)
        mmv.getR().observe(viewLifecycleOwner, {
                recipes -> myAdap.updaterv(recipes)
        })

        myAdap = RecipeAdap(this)
        rvRecip.adapter = myAdap
        rvRecip.layoutManager = LinearLayoutManager(requireContext())

        mmv.getR()


        return view
    }

}