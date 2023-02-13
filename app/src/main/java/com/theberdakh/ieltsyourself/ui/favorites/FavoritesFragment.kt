package com.theberdakh.ieltsyourself.ui.favorites

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.databinding.FragmentFavoritesBinding

class FavoritesFragment: Fragment(R.layout.fragment_favorites) {
    private lateinit var binding: FragmentFavoritesBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavoritesBinding.bind(view)

    }
}