package com.theberdakh.ieltsyourself.ui.me

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.theberdakh.ieltsyourself.core.domain.model.Setting
import com.theberdakh.ieltsyourself.core.domain.model.objects.Settings
import com.theberdakh.ieltsyourself.databinding.ItemRecyclerMeBinding

class MeRecyclerAdapter(): ListAdapter<Setting, MeRecyclerAdapter.MeViewHolder>(MeDiffCall) {

    inner class MeViewHolder(private val binding: ItemRecyclerMeBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(){
            binding.apply {
                val setting = getItem(adapterPosition)
                root.text = setting.name
                root.setOnClickListener {
                    onItemClicked.invoke(setting)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeViewHolder {
        return MeViewHolder(
            ItemRecyclerMeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MeViewHolder, position: Int) = holder.bind()


    private object MeDiffCall: DiffUtil.ItemCallback<Setting>(){
        override fun areItemsTheSame(oldItem: Setting, newItem: Setting): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Setting, newItem: Setting): Boolean {
            return oldItem.name == newItem.name
        }

    }

    private lateinit var onItemClicked: (Setting) -> Unit
    fun onItemClicked(nItemClicked: (Setting) -> Unit){
        onItemClicked = nItemClicked
    }


}