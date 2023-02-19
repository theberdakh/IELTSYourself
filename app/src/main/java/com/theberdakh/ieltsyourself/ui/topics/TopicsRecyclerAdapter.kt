package com.theberdakh.ieltsyourself.ui.topics

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.theberdakh.ieltsyourself.core.domain.model.Topic
import com.theberdakh.ieltsyourself.databinding.ItemRecyclerTopicBinding

class TopicsRecyclerAdapter : ListAdapter<Topic,TopicsRecyclerAdapter.TopicsViewHolder>(TopicsCallback){

    inner class TopicsViewHolder(private val binding: ItemRecyclerTopicBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(){
            binding.apply {
                val topic = getItem(adapterPosition)
                root.setOnClickListener {
                    onTopicClick.invoke(topic)
                }
                tvTitleTopic.text = topic.name
                tvDescriptionTopic.text = topic.description
            }
        }
    }

    private object TopicsCallback: DiffUtil.ItemCallback<Topic>(){
        override fun areItemsTheSame(oldItem: Topic, newItem: Topic): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Topic, newItem: Topic): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.name == newItem.name &&
                    oldItem.description == newItem.description &&
                    oldItem.image == newItem.image &&
                    oldItem.size == newItem.size &&
                    oldItem.level == newItem.level &&
                    oldItem.status== newItem.status
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicsViewHolder {
        return TopicsViewHolder(ItemRecyclerTopicBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun onBindViewHolder(holder: TopicsViewHolder, position: Int) =  holder.bind()

    private lateinit var onTopicClick: (Topic) -> Unit
    fun onTopicClickedListener(onTopicClick: (Topic) -> Unit){
        this.onTopicClick = onTopicClick
    }
}