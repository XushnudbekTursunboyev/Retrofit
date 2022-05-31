package com.example.retrofitlastlesson.api

import com.example.retrofitlastlesson.api.retrofit.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiBuilder {

    var retrofit: Retrofit? = null

    fun apiService():ApiService{
        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://picsum.photos/")
                .build()
        }
        return retrofit!!.create(ApiService::class.java)
    }
}