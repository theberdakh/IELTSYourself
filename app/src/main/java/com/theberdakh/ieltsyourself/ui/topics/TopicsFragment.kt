package com.theberdakh.ieltsyourself.ui.topics

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.Navigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.core.domain.model.Game
import com.theberdakh.ieltsyourself.core.domain.model.Topic
import com.theberdakh.ieltsyourself.core.presentation.TopicsViewModel
import com.theberdakh.ieltsyourself.databinding.FragmentTopicsBinding
import com.theberdakh.ieltsyourself.ui.main.MainFragmentDirections
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class TopicsFragment : Fragment(R.layout.fragment_topics) {
    private lateinit var binding: FragmentTopicsBinding
    private lateinit var navController: NavController
    private lateinit var viewModel: TopicsViewModel
    private var _adapter: TopicsRecyclerAdapter? = null
    private val adapter get() = _adapter!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTopicsBinding.bind(view)
        _adapter = TopicsRecyclerAdapter()
        navController = Navigation.findNavController(requireActivity(), R.id.parent_container)
        viewModel = ViewModelProvider(requireActivity())[TopicsViewModel::class.java]

        initObservers()

        binding.apply {
            rvTopics.adapter = adapter
            adapter.onTopicClickedListener {
                navigateToTopicFragment(it)
            }
        }
    }

    private fun navigateToTopicFragment(topic: Topic) {
        navController.navigate(MainFragmentDirections.actionMainFragmentToTopicFragment(topic, false))
    }

    private fun initObservers() {
        lifecycleScope.launchWhenResumed {
            viewModel.getAllMyTopics()
        }
        viewModel.topicsFlow.onEach {
            adapter.submitList(it)
        }.launchIn(lifecycleScope)
    }
}