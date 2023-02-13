package com.theberdakh.ieltsyourself.ui.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.databinding.FragmentSearchBinding

class SearchFragment: Fragment(R.layout.fragment_search) {
    private lateinit var binding: FragmentSearchBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchBinding.bind(view)

        binding.apply {

            vpSearch.adapter = ViewPagerSearchAdapter(requireActivity().supportFragmentManager, requireActivity().lifecycle)

            TabLayoutMediator(tbSearch, vpSearch){tab, position->
                when(position){
                    0 -> tab.text = "All words"
                    else -> tab.text = "Favorites"
                }
            }.attach()

        }
    }
}