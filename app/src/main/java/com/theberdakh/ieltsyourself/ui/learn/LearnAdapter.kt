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
                tvTitle.text = topic.name
                tvLevel.text = topic.level.toString()
            }
        }
    }

    var topics = mutableListOf<Topic>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_topic, parent, false)
        val binding = ItemRecyclerTopicBinding.bind(view)
        return LearnViewHolder(binding)
    }

    override fun getItemCount() = topics.size

    override fun onBindViewHolder(holder: LearnViewHolder, position: Int) {
        holder.bind(topics[position])
    }


}