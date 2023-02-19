package com.theberdakh.ieltsyourself.ui.choose

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.view.menu.MenuBuilder
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.core.domain.model.Game
import com.theberdakh.ieltsyourself.core.domain.model.Topic
import com.theberdakh.ieltsyourself.core.presentation.ChooseViewModel
import com.theberdakh.ieltsyourself.databinding.FragmentChooseBinding
import com.theberdakh.ieltsyourself.ui.topic_edit.TopicEditFragmentDirections
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ChooseFragment: Fragment(R.layout.fragment_choose) {
    private lateinit var binding: FragmentChooseBinding
    private lateinit var navController: NavController
    private lateinit var viewModel: ChooseViewModel
    private var _adapter: ChooseAdapter? = null
    private val adapter get() = _adapter!!
    private lateinit var game: Game
    private lateinit var topic: Topic

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentChooseBinding.bind(view)
        val args: ChooseFragmentArgs by navArgs()
        game = args.game

        viewModel = ViewModelProvider(requireActivity())[ChooseViewModel::class.java]
        navController = Navigation.findNavController(requireActivity(), R.id.parent_container)
        _adapter = ChooseAdapter()


        adapter.onTopicClickedListener {
            showDialog(it)
        }

        initObservers()
        binding.rvChoose.adapter = adapter

        binding.tbChoose.apply {
            setNavigationOnClickListener {
                navController.popBackStack()
            }
        }


    }

    private fun showDialog(topic: Topic) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.practise))
            .setMessage(getString(R.string.start_game_dialog_choose, topic.name))
            .setPositiveButton(getString(R.string.start)){dialog, position ->
                dialog.dismiss()
                navController.navigate(ChooseFragmentDirections.actionChooseFragmentToPractiseFragment(topic))
            }
            .setNegativeButton(R.string.cancel){dialog, position ->
                dialog.dismiss()
            }.show()
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