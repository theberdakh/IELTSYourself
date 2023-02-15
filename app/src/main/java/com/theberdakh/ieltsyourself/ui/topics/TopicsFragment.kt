package com.theberdakh.ieltsyourself.ui.topics

import android.app.Activity
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
import com.theberdakh.ieltsyourself.databinding.FragmentTopicsBinding

class TopicsFragment : Fragment(R.layout.fragment_topics) {
    private lateinit var binding: FragmentTopicsBinding
    private lateinit var menuHost: FragmentActivity
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTopicsBinding.bind(view)
         menuHost = requireActivity()


        setAppBarTitle()
        addMenuProvider()



        binding.apply {


        }
    }

    private fun addMenuProvider() {
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                if (menu.hasVisibleItems()){
                    menu.clear()
                }
                menuInflater.inflate(R.menu.menu_top_topics, menu)

            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.action_search_topics -> {
                        true
                    }

                    else -> false
                }
            }

        })

    }

    private fun setAppBarTitle() {
        (activity as AppCompatActivity).supportActionBar?.title = "Topics"

    }

}