package com.theberdakh.ieltsyourself.ui.my_topics

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.core.domain.model.Topic
import com.theberdakh.ieltsyourself.core.presentation.MyTopicsViewModel
import com.theberdakh.ieltsyourself.databinding.FragmentMyTopicsBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MyTopicsFragment : Fragment(R.layout.fragment_my_topics) {
    private lateinit var binding: FragmentMyTopicsBinding
    private lateinit var navController: NavController
    private lateinit var viewModel: MyTopicsViewModel
    private var _adapter: MyTopicsAdapter? = null
    private val adapter get() = _adapter!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMyTopicsBinding.bind(view)
        navController = requireActivity().findNavController(R.id.parent_container)
        viewModel = ViewModelProvider(requireActivity())[MyTopicsViewModel::class.java]
        _adapter = MyTopicsAdapter()

        initObservers()



        binding.apply {
            rvMyTopics.adapter = adapter


            adapter.setOnTopicClickedListener { topic ->
                navigateToTopicFragment(topic)
            }

            tbMyTopics.setNavigationOnClickListener {
                navController.popBackStack()
            }

            tbMyTopics.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.action_top_my_topics -> {
                        navigateToNewTopicFragment()
                        true
                    }
                    else -> {
                        false
                    }
                }
            }
        }

    }

    private fun navigateToTopicFragment(topic: Topic) {
        navController.navigate(
            MyTopicsFragmentDirections.actionMyTopicsFragmentToTopicFragment(
                topic, true
            )
        )
    }

    private fun initObservers() {
        lifecycleScope.launchWhenResumed {
            viewModel.getAllMyTopics()

        }
        viewModel.myTopicsFlow.onEach {
            adapter.submitList(it)
        }.launchIn(lifecycleScope)


    }


    private fun navigateToNewTopicFragment() {
        navController.navigate(MyTopicsFragmentDirections.actionMyTopicsFragmentToNewTopicFragment())
    }
}