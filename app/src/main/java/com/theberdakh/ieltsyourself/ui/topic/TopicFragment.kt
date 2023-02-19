package com.theberdakh.ieltsyourself.ui.topic

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.core.domain.model.Topic
import com.theberdakh.ieltsyourself.core.domain.model.Word
import com.theberdakh.ieltsyourself.core.presentation.TopicViewModel
import com.theberdakh.ieltsyourself.databinding.FragmentTopicBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class TopicFragment : Fragment(R.layout.fragment_topic) {
    private lateinit var binding: FragmentTopicBinding
    private lateinit var navController: NavController
    private lateinit var topic: Topic
    private lateinit var viewModel: TopicViewModel
    private var _adapter: TopicRecyclerAdapter? = null
    private val adapter get() = _adapter!!
    private var showEdit: Boolean = false


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTopicBinding.bind(view)
        navController = Navigation.findNavController(requireActivity(), R.id.parent_container)
        _adapter = TopicRecyclerAdapter()
        viewModel = ViewModelProvider(requireActivity())[TopicViewModel::class.java]
        val args: TopicFragmentArgs by navArgs()
        topic = args.topic
        showEdit = args.showEdit


        binding.fabTopic.setOnClickListener {
            navigateToNewWordFragment()
        }

        initObservers()
        viewModel.topicFlow.onEach {
            this.topic = it
        }.launchIn(lifecycleScope)


        adapter.setOnWordClickedListener {
            navigateToWordFragment(it)
        }
        setUpToolBar()
        setUpRecyclerView()

    }

    private fun navigateToWordFragment(word: Word) {
        navController.navigate(TopicFragmentDirections.actionTopicFragmentToWordEditFragment(word))
    }

    private fun navigateToNewWordFragment() {
        navController.navigate(TopicFragmentDirections.actionTopicFragmentToNewWordFragment(topic))
    }

    private fun initObservers() {

        lifecycleScope.launchWhenResumed {
            viewModel.apply {
                getWordsByTopic(topic)
                getUpdatedTopic(topic)
            }
        }


    }

    private fun setUpRecyclerView() {
        binding.apply {
            rvTopic.adapter = adapter
            viewModel.wordFlow.onEach {
                adapter.submitList(it)
                viewModel.updateTopicSize(topic.copy(size = it.size))
            }.launchIn(lifecycleScope)
        }
    }

    private fun navigateToTopicEditFragment() {
        navController.navigate(TopicFragmentDirections.actionTopicFragmentToTopicEditFragment(
            topic
        ))
    }

    private fun setUpToolBar() {

        if (!showEdit){
            binding.tbTopic.menu.clear()
        }

        viewModel.topicFlow.onEach { topic ->
            this.topic = topic
            binding.tbTopic.apply {
                title = topic.name
                subtitle = topic.size.toString()
            }
        }.launchIn(lifecycleScope)


        binding.tbTopic.setNavigationOnClickListener { navController.popBackStack() }

        binding.tbTopic.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_topic_edit -> {
                        navigateToTopicEditFragment()
                    true
                }
                else -> {
                    false
                }
            }


        }
    }


}