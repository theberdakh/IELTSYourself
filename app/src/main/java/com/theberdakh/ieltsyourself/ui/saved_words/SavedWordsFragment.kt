package com.theberdakh.ieltsyourself.ui.saved_words

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.databinding.FragmentSavedWordsBinding

class SavedWordsFragment : Fragment(R.layout.fragment_saved_words) {
    private lateinit var binding: FragmentSavedWordsBinding
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSavedWordsBinding.bind(view)
        navController = requireActivity().findNavController(R.id.parent_container)

    }


}