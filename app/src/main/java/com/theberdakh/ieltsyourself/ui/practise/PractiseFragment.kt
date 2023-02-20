package com.theberdakh.ieltsyourself.ui.practise

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.core.domain.model.Topic
import com.theberdakh.ieltsyourself.core.domain.model.Word
import com.theberdakh.ieltsyourself.core.presentation.PractiseViewModel
import com.theberdakh.ieltsyourself.databinding.FragmentPractiseBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class PractiseFragment: Fragment(R.layout.fragment_practise) {
    private lateinit var binding: FragmentPractiseBinding
    private lateinit var topic: Topic
    private lateinit var viewModel: PractiseViewModel
    private var words = mutableListOf<Word>()
    private var currentQuestion = 1
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPractiseBinding.bind(view)
        val args: PractiseFragmentArgs by navArgs()
        viewModel = ViewModelProvider(requireActivity())[PractiseViewModel::class.java]
        topic = args.topic



        initObservers()
        setGame()


        binding.btnSubmitPractise.setOnClickListener {
            if (currentQuestion<words.size){
                currentQuestion++
                setGame()
            }

        }

    }
    private fun initObservers() {




    }

    private fun setGame() {
        lifecycleScope.launchWhenResumed {
            viewModel.getAllWordsByTopicId(topic)
        }

        viewModel.practiseFlow.onEach {
            words.addAll(it)
        }.launchIn(lifecycleScope)

        updateTitle()
        updateQuestion()
        updateOptions()

    }

    private fun updateOptions() {

    }

    private fun updateQuestion() {

    }

    private fun updateTitle() {

        binding.tbPractise.apply {
            subtitle = getString(R.string.subtitle_practise, currentQuestion, words.size)
        }

    }


}