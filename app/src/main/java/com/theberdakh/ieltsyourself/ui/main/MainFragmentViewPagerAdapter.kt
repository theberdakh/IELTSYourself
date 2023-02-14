package com.theberdakh.ieltsyourself.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.StatefulAdapter
import com.theberdakh.ieltsyourself.ui.home.HomeFragment
import com.theberdakh.ieltsyourself.ui.me.MeFragment
import com.theberdakh.ieltsyourself.ui.search.SearchFragment
import com.theberdakh.ieltsyourself.ui.topics.TopicsFragment

class MainFragmentViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount() = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> TopicsFragment()
            2 -> SearchFragment()
            else -> MeFragment()
        }
    }
}