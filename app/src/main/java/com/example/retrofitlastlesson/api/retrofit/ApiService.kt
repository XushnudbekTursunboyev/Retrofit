package com.example.retrofitlastlesson.api.retrofit


import com.example.retrofitlastlesson.model.ImageModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("v2/list/")
    suspend fun getImages():Response<List<ImageModel>>
}