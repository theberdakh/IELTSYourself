package com.theberdakh.ieltsyourself.ui.word

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.databinding.FragmentWordBinding

class WordFragment: Fragment(R.layout.fragment_word) {
    private lateinit var binding: FragmentWordBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWordBinding.bind(view)

    }
}