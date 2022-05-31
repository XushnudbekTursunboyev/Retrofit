package com.example.retrofitlastlesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitlastlesson.adapter.MyRecyclerAdapter
import com.example.retrofitlastlesson.api.MainViewModel
import com.example.retrofitlastlesson.api.retrofit.ApiService
import com.example.retrofitlastlesson.databinding.ActivityMainBinding
import com.example.retrofitlastlesson.model.ImageModel
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MyRecyclerAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.loadDataFromRepository()

        viewModel.getCurrencies().observe(this){list->
                adapter = MyRecyclerAdapter(list)
            binding.recyclerview.adapter = adapter
        }

    }
}