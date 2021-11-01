package com.example.recipeapp
import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.recipeapp.Model.Recipe
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class MainViewModel (application: Application):AndroidViewModel(application) {
    val db = Firebase.firestore
    private val recipes: MutableLiveData<List<Recipe>> = MutableLiveData()
    val app = application
    val rec = ArrayList<Recipe>()
    var TAG: String = "iAmMainActivity"// arrayList to add



    init {

        db.collection("recipe")
            .get()
            .addOnSuccessListener {
                    result-> // qery
                for (r in result){  // throw result
                    val list = ArrayList<String>()
                    r.data.map {
                            (key,value)->
                        list.add(value.toString())
                        Log.d(TAG, "key:${key} value:${value}")//list insted of tv
                    }
                    rec.add(Recipe(r.id,list[3],list[1],list[2],list[0]))
                }
                recipes.postValue(rec)
            }

    }


    fun getR():LiveData<List<Recipe>>{
        return recipes
    }


    fun addR(author:String,ingredients:String,instructions:String,title:String){

        if (title.isNotEmpty()&&author.isNotEmpty()&&ingredients.isNotEmpty()&&instructions.isNotEmpty())
        {
            val recipe= hashMapOf(
                "title" to title,
                "author" to author,
                "ingredients" to ingredients,
                "instructions" to instructions
            )
            db.collection("recipe").add(recipe)
            Toast.makeText(app, "recipe is added ", Toast.LENGTH_SHORT).show()
        }
        else
        {
            Toast.makeText(app, "please fill all fields", Toast.LENGTH_SHORT).show()
        }
    }

}