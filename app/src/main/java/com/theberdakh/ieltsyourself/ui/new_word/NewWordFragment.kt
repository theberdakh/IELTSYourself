package com.theberdakh.ieltsyourself.ui.new_word

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.core.domain.model.Topic
import com.theberdakh.ieltsyourself.core.domain.model.Word
import com.theberdakh.ieltsyourself.core.presentation.NewWordViewModel
import com.theberdakh.ieltsyourself.databinding.FragmentNewWordBinding
import kotlinx.coroutines.flow.onEach

class NewWordFragment : Fragment(R.layout.fragment_new_word) {
    private lateinit var binding: FragmentNewWordBinding
    private lateinit var navController: NavController
    private lateinit var viewModel: NewWordViewModel
    private lateinit var word: Word
    private lateinit var topic: Topic

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewWordBinding.bind(view)
        viewModel = ViewModelProvider(requireActivity())[NewWordViewModel::class.java]
        navController = Navigation.findNavController(requireActivity(), R.id.parent_container)
        val args: NewWordFragmentArgs by navArgs()
        topic = args.topic

        setUpMoreFieldsToggle()
        setUpToolbar()
        initObservers()

    }

    private fun initObservers() {

    }

    private fun setUpMoreFieldsToggle() {
        binding.apply {
            tilNewWordTranslation.isVisible = false
            tilNewWordExample.isVisible = false
            var toggle = false

            tvNewWordMoreFields.apply {
                setOnClickListener {
                    if (!toggle) {
                        setCompoundDrawablesWithIntrinsicBounds(
                            0,
                            0,
                            R.drawable.round_keyboard_arrow_down_24,
                            0
                        )
                        toggle = true
                        tilNewWordTranslation.isVisible = true
                        tilNewWordExample.isVisible = true

                    } else {
                        setCompoundDrawablesWithIntrinsicBounds(
                            0,
                            0,
                            R.drawable.round_keyboard_arrow_right_24,
                            0
                        )
                        toggle = false
                        tilNewWordTranslation.isVisible = false
                        tilNewWordExample.isVisible = false
                    }
                }
            }

        }
    }


    private fun setUpToolbar() {
        binding.apply {
            tbNewWord.setNavigationOnClickListener {
                navController.popBackStack()
            }

            tbNewWord.setOnMenuItemClickListener { menuItem ->
               addTextChangedListener(etNewWordName, tilNewWordName)
                addTextChangedListener(etNewWordMeaning, tilNewWordMeaning)


                when (menuItem.itemId) {
                    R.id.action_add_new_word -> {
                        if (etNewWordName.text.toString().isNotEmpty()
                            && etNewWordMeaning.text.toString().isNotEmpty()
                        ) {
                            word = Word(
                                name = etNewWordName.text.toString(),
                                meaning = etNewWordMeaning.text.toString(),
                                translation = etNewWordTranslation.text.toString(),
                                example = etNewWordExample.text.toString(),
                                topic = topic.id,
                            )

                            lifecycleScope.launchWhenResumed {
                                viewModel.addWord(word)
                                viewModel.getWordsByTopicId(word)
                            }

                            var size = 0
                            viewModel.wordFlow.onEach {
                                size = it.size
                            }
                            navController.navigate(NewWordFragmentDirections.actionNewWordFragmentToTopicFragment(topic.copy( size = size), true))



                        } else {
                            if (etNewWordName.text.toString().isEmpty()) {
                                tilNewWordName.error = getString(R.string.til_error_empty)
                            }
                            if (etNewWordMeaning.text.toString().isEmpty()) {
                                tilNewWordMeaning.error = getString(R.string.til_error_empty)
                            }
                        }
                    true
                    }
                    else -> {
                        false
                    }
                }
            }
        }
    }

    private fun addTextChangedListener(
        editText: TextInputEditText,
        textInputLayout: TextInputLayout
    ) {
        editText.addTextChangedListener {
            textInputLayout.error = null
        }

    }

}