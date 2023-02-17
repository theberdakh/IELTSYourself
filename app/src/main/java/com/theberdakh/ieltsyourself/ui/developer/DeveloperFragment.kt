package com.theberdakh.ieltsyourself.ui.developer

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.databinding.FragmentDeveloperBinding

class DeveloperFragment: Fragment(R.layout.fragment_developer) {
    private lateinit var binding: FragmentDeveloperBinding
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDeveloperBinding.bind(view)

        navController = Navigation.findNavController(requireActivity(), R.id.parent_container)


        binding.apply {
            tbDeveloper.setNavigationOnClickListener {
                navController.popBackStack()
            }
        }

    }
}