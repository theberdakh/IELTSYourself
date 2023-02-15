package com.theberdakh.ieltsyourself.ui.me

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
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.databinding.FragmentMeBinding
import com.theberdakh.ieltsyourself.ui.main.MainFragmentDirections

class MeFragment : Fragment(R.layout.fragment_me) {
    private lateinit var binding: FragmentMeBinding
    private lateinit var navController: NavController
    private lateinit var menuHost: FragmentActivity
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMeBinding.bind(view)
        menuHost = requireActivity()
        navController = requireActivity().findNavController(R.id.parent_container)


        setAppBarTitle()
        addMenuProvider()

        binding.apply {
            tvMeTopics.setOnClickListener {
                navigateToMyTopicsFragment()
            }
            tvMeSavedWords.setOnClickListener {
                navigateToSavedWordsFragment()
            }
        }

    }

    private fun navigateToSavedWordsFragment() {
        navController.navigate(MainFragmentDirections.actionMainFragmentToSavedWordsFragment())
    }

    private fun addMenuProvider() {
        menuHost.addMenuProvider(object: MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                if (menu.hasVisibleItems()){
                    menu.clear()
                }
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }

        })
    }

    private fun setAppBarTitle() {
        (activity as AppCompatActivity).supportActionBar?.title = "Me"
    }

    private fun navigateToMyTopicsFragment() {
        navController.navigate(MainFragmentDirections.actionMainFragmentToMyTopicsFragment())
    }
}