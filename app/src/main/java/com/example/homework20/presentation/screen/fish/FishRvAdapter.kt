package com.example.homework20.presentation.screen.fish

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework20.databinding.FishItemBinding
import com.example.homework20.presentation.model.fish.Fish

class FishRvAdapter : ListAdapter<Fish, FishRvAdapter.FishVH>(FishDiffUtil()) {

    class FishDiffUtil: DiffUtil.ItemCallback<Fish>(){
        override fun areItemsTheSame(oldItem: Fish, newItem: Fish): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Fish, newItem: Fish): Boolean {
            return oldItem == newItem
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FishVH = FishVH(
        FishItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: FishVH, position: Int) {
        holder.bind()
    }

    inner class FishVH(private val binding: FishItemBinding): RecyclerView.ViewHolder(binding.root){
        private lateinit var fish: Fish
        fun bind(){
            fish = currentList[adapterPosition]
            with(binding){
                tvName.text = "Name: ${fish.name}"
                tvType.text = "Type: ${fish.type}"
                tvLocation.text = "Location: ${fish.location}"
            }
        }
    }
}