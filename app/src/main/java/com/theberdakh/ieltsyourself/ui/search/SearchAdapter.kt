package com.theberdakh.ieltsyourself.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.core.domain.model.Word
import com.theberdakh.ieltsyourself.databinding.ItemRecyclerWordBinding

class SearchAdapter: RecyclerView.Adapter<SearchAdapter.SearchViewHolder>(){


    inner class SearchViewHolder(private val binding: ItemRecyclerWordBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(word: Word){
            binding.apply {
                tvTitle.text = word.name
            }
        }
    }

    var words = mutableListOf<Word>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_word, parent, false)
        val binding = ItemRecyclerWordBinding.bind(view)
        return SearchViewHolder(binding)
    }

    override fun getItemCount() = words.size

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(words[position])
    }

}