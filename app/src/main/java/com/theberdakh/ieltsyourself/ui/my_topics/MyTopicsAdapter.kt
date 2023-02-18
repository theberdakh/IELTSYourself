package com.theberdakh.ieltsyourself.ui.my_topics

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.theberdakh.ieltsyourself.core.domain.model.Topic
import com.theberdakh.ieltsyourself.databinding.ItemRecyclerTopicBinding

class MyTopicsAdapter: ListAdapter<Topic, MyTopicsAdapter.AddViewHolder>(MyTopicsDiffUtil){

    inner class AddViewHolder(private val binding:ItemRecyclerTopicBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(){
            val topic = getItem(adapterPosition)
            binding.apply {
                root.setOnClickListener {
                    topicClicked.invoke(topic)
                }
                tvTitleTopic.text = topic.name
                tvDescriptionTopic.text = topic.description
            }

        }
    }


    private object MyTopicsDiffUtil: DiffUtil.ItemCallback<Topic>() {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddViewHolder {
       return AddViewHolder(ItemRecyclerTopicBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: AddViewHolder, position: Int) = holder.bind()


    private lateinit var topicClicked: (Topic) -> Unit
    fun setOnTopicClickedListener(topicClicked: (Topic) -> Unit ){
        this.topicClicked = topicClicked
    }
}