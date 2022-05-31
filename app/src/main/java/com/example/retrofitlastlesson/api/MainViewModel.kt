package com.example.retrofitlastlesson.api

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitlastlesson.model.ImageModel
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {

    private val repository = ImagesRepository()

    private var liveData :MutableLiveData<List<ImageModel>> = MutableLiveData()

    fun getCurrencies():MutableLiveData<List<ImageModel>>{
        return liveData
    }

//    fun loadDataFromRepository(){
//        repository.getImages(liveData, error)
//    }
    fun loadDataFromRepository() = viewModelScope.launch {
        repository.getImages().let {
            liveData.postValue(it.body())
        }
}
}