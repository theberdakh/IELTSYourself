package com.theberdakh.ieltsyourself.ui.stats

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.databinding.FragmentStatsBinding

class StatsFragment: Fragment(R.layout.fragment_stats) {
    private lateinit var binding: FragmentStatsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentStatsBinding.bind(view)

    }
}