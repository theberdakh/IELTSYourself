package com.theberdakh.ieltsyourself.ui.topic

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.databinding.FragmentTopicBinding

class TopicFragment: Fragment(R.layout.fragment_topic) {
    private lateinit var binding: FragmentTopicBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTopicBinding.bind(view)
    }
}