package com.theberdakh.ieltsyourself.ui.topics

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.databinding.FragmentTopicsBinding

class TopicsFragment : Fragment(R.layout.fragment_topics) {
    private lateinit var binding: FragmentTopicsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTopicsBinding.bind(view)

        binding.apply {

            vpTopics.adapter = ViewPagerTopicsAdapter(requireActivity().supportFragmentManager, requireActivity().lifecycle)

            TabLayoutMediator(tlTopics, vpTopics) { tab, position ->
                when (position){
                    0 -> tab.text = "All"
                    else -> tab.text = "My topics"
                }
            }.attach()

        }
    }
}