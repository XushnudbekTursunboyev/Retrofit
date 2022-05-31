package com.example.retrofitlastlesson.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitlastlesson.R
import com.example.retrofitlastlesson.databinding.ItemLayoutBinding
import com.example.retrofitlastlesson.model.ImageModel

class MyRecyclerAdapter(val list: List<ImageModel>) : RecyclerView.Adapter<MyRecyclerAdapter.VH>() {

    inner class VH(var binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(imageModel: ImageModel) {
            binding.apply {
                Glide
                    .with(itemView.context)
                    .load(imageModel.downloadUrl)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(imageview)

                tvAuthor.text = imageModel.author
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}