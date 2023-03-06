package com.theberdakh.ieltsyourself.ui.choose

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.theberdakh.ieltsyourself.core.domain.model.Topic
import com.theberdakh.ieltsyourself.databinding.ItemRecyclerTopicBinding

class ChooseAdapter : ListAdapter<Topic, ChooseAdapter.ChooseViewHolder>(ChooseCallBack) {

    inner class ChooseViewHolder(private val binding: ItemRecyclerTopicBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val topic = getItem(adapterPosition)
            binding.apply {
                root.setOnClickListener {
                    onTopicClicked.invoke(topic)
                }
                tvTitleTopic.text = topic.name
                tvDescriptionTopic.text = "${topic.size} words"
            }
        }
    }

    private object ChooseCallBack : DiffUtil.ItemCallback<Topic>() {
        override fun areItemsTheSame(oldItem: Topic, newItem: Topic): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Topic, newItem: Topic): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.name == newItem.name &&
                    oldItem.status == newItem.status &&
                    oldItem.size == newItem.size &&
                    oldItem.level == newItem.level &&
                    oldItem.image == newItem.image &&
                    oldItem.description == newItem.description

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChooseViewHolder {
        return ChooseViewHolder(
            ItemRecyclerTopicBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ChooseViewHolder, position: Int) = holder.bind()

    private lateinit var onTopicClicked: (Topic) -> Unit
    fun onTopicClickedListener(onTopicClicked: (Topic) -> Unit){
        this.onTopicClicked = onTopicClicked
    }
}