package com.theberdakh.ieltsyourself.ui.topic

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.core.domain.model.Topic
import com.theberdakh.ieltsyourself.databinding.FragmentTopicBinding

class TopicFragment: Fragment(R.layout.fragment_topic) {
    private lateinit var binding: FragmentTopicBinding
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTopicBinding.bind(view)
        navController = Navigation.findNavController(requireActivity(), R.id.parent_container)

        val args: TopicFragmentArgs by navArgs()
        val topic = args.topic

        setUpToolBar(topic)
    }

    private fun setUpToolBar(topic: Topic) {

        binding.tbTopic.setNavigationOnClickListener { navController.popBackStack() }

        binding.tbTopic.title = topic.name
        binding.tbTopic.subtitle = getString(R.string.subtitle_topic, topic.size)

        binding.tbTopic.setOnMenuItemClickListener {menuItem->
            when(menuItem.itemId){
                R.id.action_top_topic -> {
                    navController.navigate(TopicFragmentDirections.actionTopicFragmentToNewWordFragment())
                    true
                }
                else -> {false}
            }



        }
    }

}