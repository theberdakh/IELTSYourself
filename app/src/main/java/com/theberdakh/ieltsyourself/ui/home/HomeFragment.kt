package com.theberdakh.ieltsyourself.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.databinding.FragmentHomeBinding

class HomeFragment: Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        val adapter = ViewPagerAdapter(requireActivity().supportFragmentManager, requireActivity().lifecycle)
        binding.apply {
            vpHome.adapter = adapter

            TabLayoutMediator(tlHome, vpHome) {tab, position ->
                when(position){
                    0-> tab.text = "Learn"
                    1 -> tab.text = "My topics"
                    2 -> tab.text = "All"
                }
            }.attach()
        }

    }
}