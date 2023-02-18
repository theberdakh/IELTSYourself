package com.theberdakh.ieltsyourself.ui.word_edit

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.databinding.FragmentWordEditBinding

class WordEditFragment: Fragment(R.layout.fragment_word_edit) {
    private lateinit var binding: FragmentWordEditBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWordEditBinding.bind(view)


    }
}