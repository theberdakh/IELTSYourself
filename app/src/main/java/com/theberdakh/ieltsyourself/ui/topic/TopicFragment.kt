package com.theberdakh.ieltsyourself.ui.topic

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.core.domain.model.Topic
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
    private var topicSize = 0


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTopicBinding.bind(view)
        navController = Navigation.findNavController(requireActivity(), R.id.parent_container)
        _adapter = TopicRecyclerAdapter()
        viewModel = ViewModelProvider(requireActivity())[TopicViewModel::class.java]

        val args: TopicFragmentArgs by navArgs()
        topic = args.topic

        initObservers()

        adapter.setOnWordClickedListener { }
        setUpRecyclerView()

    }

    private fun updateTopicSize() {
        lifecycleScope.launchWhenResumed {
            viewModel.updateTopicSize(topic.copy(size = topicSize))
        }

    }

    private fun initObservers() {
        viewModel.wordFlow.onEach {
            adapter.submitList(it)
            topicSize = it.size

        }.launchIn(lifecycleScope)

        updateTopicSize()
        setUpToolBar(topic)

    }

    private fun setUpRecyclerView() {
        binding.apply {
            rvTopic.adapter = adapter


            lifecycleScope.launchWhenResumed {
                viewModel.getWordsByTopic(topic)
                updateTopicSize()
            }

            fabTopic.setOnClickListener {
                navController.navigate(
                    TopicFragmentDirections.actionTopicFragmentToNewWordFragment(
                        topic
                    )
                )
            }
        }
    }

    private fun setUpToolBar(topic: Topic) {

        binding.tbTopic.apply {
            setNavigationOnClickListener { navController.popBackStack() }
            title = topic.name
            subtitle = topic.size.toString()
        }


        binding.tbTopic.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_topic_edit -> {
                    navController.navigate(
                        TopicFragmentDirections.actionTopicFragmentToTopicEditFragment(
                            topic
                        )
                    )
                    true
                }
                else -> {
                    false
                }
            }


        }
    }

    override fun onResume() {
        super.onResume()
        updateTopicSize()

    }

}