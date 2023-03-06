package com.theberdakh.ieltsyourself.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.theberdakh.ieltsyourself.core.domain.model.Game
import com.theberdakh.ieltsyourself.databinding.ItemRecyclerLearnBinding

class HomeRecyclerAdapter() :
    ListAdapter<Game, HomeRecyclerAdapter.HomeViewHolder>(HomeDiffCallback) {

    inner class HomeViewHolder(private val binding: ItemRecyclerLearnBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.apply {
                val game = getItem(adapterPosition)
                tvTitleLearn.text = game.name
                root.setOnClickListener {
                    cardClicked.invoke(game)
                }
                btnPractiseLearn.setOnClickListener {
                    practiseClicked.invoke(game)
                }
                ivLearn.setImageDrawable(ContextCompat.getDrawable(ivLearn.context, game.image))
            }
        }
    }

    private object HomeDiffCallback : DiffUtil.ItemCallback<Game>() {
        override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.name == newItem.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(ItemRecyclerLearnBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) = holder.bind()

    private lateinit var cardClicked: (Game) -> Unit
    fun setOnCardClickedListener(cardClicked: (Game) -> Unit){
        this.cardClicked = cardClicked
    }

    private lateinit var practiseClicked: (Game) -> Unit
    fun setOnPractiseClickedListener(practiseClicked: (Game) -> Unit){
        this.practiseClicked = practiseClicked
    }
}


