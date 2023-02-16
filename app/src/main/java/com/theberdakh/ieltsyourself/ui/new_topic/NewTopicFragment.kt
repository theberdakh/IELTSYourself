package com.theberdakh.ieltsyourself.ui.new_topic

import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.core.domain.model.Topic
import com.theberdakh.ieltsyourself.core.presentation.NewTopicViewModel
import com.theberdakh.ieltsyourself.databinding.FragmentNewTopicBinding
import kotlinx.coroutines.Dispatchers

class NewTopicFragment: Fragment(R.layout.fragment_new_topic) {
    private lateinit var binding: FragmentNewTopicBinding
    private lateinit var viewModel: NewTopicViewModel
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewTopicBinding.bind(view)
        viewModel = ViewModelProvider(requireActivity())[NewTopicViewModel::class.java]
        navController = Navigation.findNavController(requireActivity(), R.id.parent_container)


    }

    private fun navigateToMainFragment() {
       // navController.navigate(R.id.action_newTopicFragment_to_mainFragment)
    }

    private fun navigateToTopicFragment() {
        binding.apply {
            if (etNewTopicName.text.toString().isEmpty()){
                tilNewTopicName.error = "The topic name can not be empty!"
            }
            else {
                navController.navigate(R.id.action_mainFragment_to_myTopicsFragment)
            }
        }
    }
}