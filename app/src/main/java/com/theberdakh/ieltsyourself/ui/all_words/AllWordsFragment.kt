package com.theberdakh.ieltsyourself.ui.all_words

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.databinding.FragmentAllWordsBinding

class AllWordsFragment: Fragment(R.layout.fragment_all_words) {
    private lateinit var binding:FragmentAllWordsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAllWordsBinding.bind(view)
    }
}