package com.theberdakh.ieltsyourself.ui.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.databinding.FragmentHomeBinding

class HomeFragment: Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var menuHost: FragmentActivity
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        menuHost = requireActivity()

        addMenuProvider()
        setAppBarTitle()



        binding.apply {

        }

    }

    private fun setAppBarTitle() {
        (activity as AppCompatActivity).supportActionBar?.title = "Home"
    }

    private fun addMenuProvider() {
        menuHost.addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                if (menu.hasVisibleItems()){
                    menu.clear()
                }
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return true
            }

        })
    }
}