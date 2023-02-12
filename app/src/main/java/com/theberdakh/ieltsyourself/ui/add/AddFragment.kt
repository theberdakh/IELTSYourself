package com.theberdakh.ieltsyourself.ui.add

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.databinding.FragmentAddBinding

class AddFragment: Fragment(R.layout.fragment_add) {
    private lateinit var binding: FragmentAddBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAddBinding.bind(view)


    }
}