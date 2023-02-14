package com.theberdakh.ieltsyourself.ui.me

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.databinding.FragmentMeBinding

class MeFragment: Fragment(R.layout.fragment_me) {
    private lateinit var binding: FragmentMeBinding
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMeBinding.bind(view)

        navController = requireActivity().findNavController(R.id.parent_container)

        binding.apply {
            tvMeTopics.setOnClickListener {
                navigateToMyTopicsFragment()
            }
        }

    }

    private fun navigateToMyTopicsFragment() {
        navController.navigate(R.id.action_mainFragment_to_myTopicsFragment)
    }
}