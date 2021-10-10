package com.example.recipeapp

import android.app.ProgressDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.card.view.*
import retrofit2.Callback

class RecipeAdap(private val context: Context, val recapis: List<RecipeDeta.recDatum>) :
    RecyclerView.Adapter<RecipeAdap.MessageViewHolder>() {
    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.card,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val recipe = recapis[position]

        holder.itemView.apply {
            tvTitle.text ="  .. ${recipe.title} .."
            tvAuthor.text = "By :${recipe.author}"
            cvMain.setOnClickListener {
                AlertDialog.Builder(context)
                    .setTitle("the instur and ingred")
                    .setMessage("The Insturction:${recipe.instructions}\n The Ingredients ${recipe.ingredients}")
                    .setNegativeButton("Cancle") { dilog, id -> dilog.cancel() }
                    .show()
            }
        }
    }

    override fun getItemCount() = recapis.size
}