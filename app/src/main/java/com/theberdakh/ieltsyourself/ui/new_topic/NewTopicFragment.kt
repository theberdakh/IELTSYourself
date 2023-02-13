package com.theberdakh.ieltsyourself.ui.new_topic

import android.os.Bundle
import android.text.Layout.Directions
import android.view.MenuItem
import android.view.View
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.annotation.LayoutRes
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ListAdapter
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.core.domain.model.Topic
import com.theberdakh.ieltsyourself.core.presentation.NewTopicViewModel
import com.theberdakh.ieltsyourself.databinding.FragmentNewTopicBinding

class NewTopicFragment: Fragment(R.layout.fragment_new_topic) {
    private lateinit var binding: FragmentNewTopicBinding
    private lateinit var viewModel: NewTopicViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewTopicBinding.bind(view)
        viewModel = ViewModelProvider(requireActivity())[NewTopicViewModel::class.java]


        binding.apply {
            tbNewTopic.menu.getItem(R.menu.menu_top_new_topic).setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.action_add_new_topic -> {
                        navigateToTopicFragment()
                    }
                }
                true
            }
        }
    }

    private fun navigateToTopicFragment() {
        binding.apply {
            if (etNewTopicName.text.toString().isBlank()){
                val topic = Topic(name = etNewTopicName.text.toString())
                lifecycleScope.launchWhenResumed {
                    viewModel.addNewTopic(topic)
                }
                val navController = Navigation.findNavController(requireActivity(), R.id.parent_container)

            }
        }
    }
}