package com.theberdakh.ieltsyourself.ui.all_topics

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.databinding.FragmentAllTopicsBinding

class AllTopicsFragment: Fragment(R.layout.fragment_all_topics) {
    private lateinit var binding: FragmentAllTopicsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAllTopicsBinding.bind(view)
    }


}