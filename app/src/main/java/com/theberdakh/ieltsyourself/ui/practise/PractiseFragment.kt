package com.theberdakh.ieltsyourself.ui.practise

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.core.domain.model.Topic
import com.theberdakh.ieltsyourself.databinding.FragmentPractiseBinding

class PractiseFragment: Fragment(R.layout.fragment_practise) {
    private lateinit var binding: FragmentPractiseBinding
    private lateinit var topic: Topic
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPractiseBinding.bind(view)
        val args: PractiseFragmentArgs by navArgs()
        topic = args.topic

        binding.apply {

        }


    }
}