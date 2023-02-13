package com.theberdakh.ieltsyourself.ui.topics

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.theberdakh.ieltsyourself.ui.my_topics.MyTopicsFragment
import com.theberdakh.ieltsyourself.ui.all_topics.AllTopicsFragment

class ViewPagerTopicsAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> AllTopicsFragment()
            else -> MyTopicsFragment()
        }
    }

}