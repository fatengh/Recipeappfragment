package com.example.recipeapp

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface {
    @Headers("Content-Type: application/json")
    @GET("/recipes/")
    fun getRecipies(): Call<List<RecipeDeta.recDatum>>


    @Headers("Content-Type: application/json")
    @POST("/recipes/")
    fun addRecipie(@Body userData: RecipeDeta.recDatum): Call<RecipeDeta.recDatum>

}