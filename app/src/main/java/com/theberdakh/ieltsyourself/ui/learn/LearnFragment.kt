package com.theberdakh.ieltsyourself.ui.learn

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.databinding.FragmentHomeBinding
import com.theberdakh.ieltsyourself.databinding.FragmentLearnBinding

class LearnFragment: Fragment(R.layout.fragment_learn) {
    private lateinit var binding: FragmentLearnBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLearnBinding.inflate(layoutInflater)



    }
}