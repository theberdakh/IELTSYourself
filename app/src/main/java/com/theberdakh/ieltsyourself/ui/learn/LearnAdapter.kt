package com.theberdakh.ieltsyourself.ui.learn

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.core.domain.model.Topic
import com.theberdakh.ieltsyourself.databinding.ItemRecyclerTopicBinding

class LearnAdapter: RecyclerView.Adapter<LearnAdapter.LearnViewHolder>(){
    inner class LearnViewHolder(private val binding: ItemRecyclerTopicBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(topic: Topic){
            binding.apply {

            }
        }

        var topics = mutableListOf<Topic>()



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: LearnViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}
