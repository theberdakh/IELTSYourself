package com.theberdakh.ieltsyourself.ui.me

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.databinding.FragmentMeBinding

class MeFragment: Fragment(R.layout.fragment_me) {
    private lateinit var binding: FragmentMeBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMeBinding.bind(view)

    }
}