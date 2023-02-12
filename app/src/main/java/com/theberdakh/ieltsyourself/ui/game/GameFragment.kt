package com.theberdakh.ieltsyourself.ui.game

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.databinding.FragmentGameBinding

class GameFragment: Fragment(R.layout.fragment_game
) {
    private lateinit var binding: FragmentGameBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGameBinding.bind(view)

    }
}