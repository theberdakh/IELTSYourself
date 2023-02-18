package com.theberdakh.ieltsyourself.ui.new_topic

import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
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
import com.theberdakh.ieltsyourself.utils.makeToast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class NewTopicFragment : Fragment(R.layout.fragment_new_topic) {
    private lateinit var binding: FragmentNewTopicBinding
    private lateinit var viewModel: NewTopicViewModel
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewTopicBinding.bind(view)
        viewModel = ViewModelProvider(requireActivity())[NewTopicViewModel::class.java]
        navController = Navigation.findNavController(requireActivity(), R.id.parent_container)

        setBackNavigation()
        navigateToTopicFragment()


    }

    private fun addTextChangedListener(): Boolean {
        var condition = false
        binding.apply {
            etNewTopicName.addTextChangedListener {
                if (it.toString().isEmpty()) {
                    tilNewTopicName.error = getString(R.string.til_error_empty)
                } else {
                    tilNewTopicName.error = null
                    condition = true
                }
            }
        }
        return condition
    }

    private fun setBackNavigation() {
        binding.tbNewTopic.setNavigationOnClickListener {
            navController.popBackStack()
        }
    }

    private fun navigateToTopicFragment() {
        addTextChangedListener()
        binding.apply {
            tbNewTopic.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.action_top_new_topic -> {
                        if (etNewTopicName.text.toString().isNotEmpty()) {

                            val topic = Topic(
                                name = etNewTopicName.text.toString(),
                                description = etNewTopicDescription.text.toString()
                            )

                            lifecycleScope.launchWhenResumed {
                                viewModel.addNewTopic(topic)
                            }

                            navController.popBackStack()

                            true
                        } else {
                            tilNewTopicName.error = getString(R.string.til_error_empty)
                            false
                        }
                    }
                    else -> {
                        false
                    }
                }
            }

        }
    }
}