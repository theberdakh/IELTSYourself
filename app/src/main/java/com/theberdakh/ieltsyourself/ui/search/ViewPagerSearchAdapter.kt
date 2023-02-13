package com.theberdakh.ieltsyourself.ui.search

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.theberdakh.ieltsyourself.ui.all_words.AllWordsFragment
import com.theberdakh.ieltsyourself.ui.favorites.FavoritesFragment

class ViewPagerSearchAdapter(fragmentManager: FragmentManager,  lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
      return  when(position){
            0 -> AllWordsFragment()
            else -> FavoritesFragment()
        }
    }

}