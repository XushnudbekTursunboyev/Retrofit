package com.example.retrofitlastlesson.api

import com.example.retrofitlastlesson.model.ImageModel
import retrofit2.Response

class ImagesRepository {

    suspend fun getImages(): Response<List<ImageModel>>{

        return ApiBuilder.apiService().getImages()
    }
}