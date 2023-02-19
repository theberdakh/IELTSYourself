package com.theberdakh.ieltsyourself.ui.word_edit

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.core.domain.model.Word
import com.theberdakh.ieltsyourself.core.presentation.WordEditViewModel
import com.theberdakh.ieltsyourself.databinding.FragmentWordEditBinding
import com.theberdakh.ieltsyourself.ui.topic_edit.TopicEditFragmentDirections

class WordEditFragment: Fragment(R.layout.fragment_word_edit) {
    private lateinit var binding: FragmentWordEditBinding
    private lateinit var viewModel: WordEditViewModel
    private lateinit var navController: NavController
    private lateinit var word: Word
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWordEditBinding.bind(view)
        viewModel = ViewModelProvider(requireActivity())[WordEditViewModel::class.java]
        navController = Navigation.findNavController(requireActivity(), R.id.parent_container)
        val args: WordEditFragmentArgs by navArgs()
        word = args.word


        binding.apply {
            setNameField(tilEditWordName, etEditWordName, word.name, getString(R.string.til_error_empty))
            setNameField(tilEditWordMeaning, etEditWordMeaning, word.meaning, getString(R.string.til_error_empty))
            setNameField(tilEditWordTranslation, etEditWordTranslation, word.translation?:"")
            setNameField(tilEditWordExample, etEditWordExample, word.example?:"",)
        }

        binding.tbEditWord.apply {
            setNavigationOnClickListener {
                navController.popBackStack()
            }

            setOnMenuItemClickListener {menItem->
                when(menItem.itemId){
                    R.id.action_add_edit_word -> {
                        binding.apply {
                            if (etEditWordName.text.toString().isNotEmpty()&&etEditWordMeaning.text.toString().isNotEmpty()){
                                val updatedWord = word.copy(
                                    name = etEditWordName.text.toString(),
                                    meaning = etEditWordMeaning.text.toString(),
                                    translation = etEditWordTranslation.text.toString(),
                                    example = etEditWordExample.text.toString()
                                )

                                lifecycleScope.launchWhenResumed {
                                    viewModel.updateWord(updatedWord)
                                }
                                navController.popBackStack()
                            }
                        }
                        true
                    }
                    else -> false
                }
            }
        }


        binding.tvEditWordDelete.setOnClickListener {
            lifecycleScope.launchWhenResumed {
                viewModel.deleteWord(word)
                Toast.makeText(requireContext(), "The word ${word.name} is deleted successfully!", Toast.LENGTH_SHORT).show()
            }
            navController.popBackStack()
        }




    }

    private fun setNameField(til: TextInputLayout, et: TextInputEditText, value: String, error: String? = null) {
        et.setText(value)
        et.addTextChangedListener {
            til.error = if (et.text.toString().isEmpty()) error else null
        }
    }
}