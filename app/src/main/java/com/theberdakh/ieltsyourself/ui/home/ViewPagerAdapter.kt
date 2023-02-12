package com.theberdakh.ieltsyourself.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.theberdakh.ieltsyourself.ui.add.AddFragment
import com.theberdakh.ieltsyourself.ui.learn.LearnFragment
import com.theberdakh.ieltsyourself.ui.topics.TopicsFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> LearnFragment()
            1 -> AddFragment()
            else -> TopicsFragment()
        }
    }

}