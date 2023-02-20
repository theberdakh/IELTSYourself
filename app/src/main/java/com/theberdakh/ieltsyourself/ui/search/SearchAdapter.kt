package com.theberdakh.ieltsyourself.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.core.domain.model.Word
import com.theberdakh.ieltsyourself.databinding.ItemRecyclerWordBinding

class SearchAdapter: ListAdapter<Word,SearchAdapter.SearchViewHolder>(SearchCallBack) {

    inner class SearchViewHolder(private val binding: ItemRecyclerWordBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(){
            val word = getItem(adapterPosition)
            binding.apply {
                tvTitle.text = word.name
                tvSubtitle.text = word.meaning
                if (word.isSaved==1){
                    tvTitle.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.round_star_24, 0)
                }
                else {
                    tvTitle.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
                }
            }
        }
    }



    private object SearchCallBack: DiffUtil.ItemCallback<Word>(){
        override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem.name ==  newItem.name
        }

        override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.name == newItem.name &&
                    oldItem.topic == newItem.topic &&
                    oldItem.example == newItem.example &&
                    oldItem.isSaved == newItem.isSaved &&
                    oldItem.isSearched == newItem.isSearched &&
                    oldItem.meaning == newItem.meaning &&
                    oldItem.status == newItem.status &&
                    oldItem.translation == newItem.translation
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(ItemRecyclerWordBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int)  = holder.bind()

    private lateinit var onWordClicked : (Word) -> Unit
    fun setOnWordClickedListener(onWordClicked: (Word) -> Unit){
        this.onWordClicked = onWordClicked
    }

}