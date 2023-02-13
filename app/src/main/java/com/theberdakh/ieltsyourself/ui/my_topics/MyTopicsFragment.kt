package com.theberdakh.ieltsyourself.ui.my_topics

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.databinding.FragmentMyTopicsBinding

class MyTopicsFragment: Fragment(R.layout.fragment_my_topics) {
    private lateinit var binding: FragmentMyTopicsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMyTopicsBinding.bind(view)

        binding.apply {
            cvMyTopicsNewTopic.setOnClickListener {
                navigateToNewTopicFragment()
            }
        }


    }

    private fun navigateToNewTopicFragment() {
        val navController = Navigation.findNavController(requireActivity(), R.id.parent_container)
        navController.navigate(R.id.action_mainFragment_to_newTopicFragment)
    }
}