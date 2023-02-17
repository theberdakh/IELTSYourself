package com.theberdakh.ieltsyourself.ui.saved_words

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.databinding.FragmentSavedWordsBinding
import com.theberdakh.ieltsyourself.utils.makeToast

class SavedWordsFragment : Fragment(R.layout.fragment_saved_words) {
    private lateinit var binding: FragmentSavedWordsBinding
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSavedWordsBinding.bind(view)
        navController = requireActivity().findNavController(R.id.parent_container)

    }


}