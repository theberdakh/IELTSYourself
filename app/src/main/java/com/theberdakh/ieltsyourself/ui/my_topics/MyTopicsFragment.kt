package com.theberdakh.ieltsyourself.ui.my_topics

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
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.databinding.FragmentMyTopicsBinding
import com.theberdakh.ieltsyourself.ui.main.MainFragmentDirections

class MyTopicsFragment : Fragment(R.layout.fragment_my_topics) {
    private lateinit var binding: FragmentMyTopicsBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var menuHost: FragmentActivity

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMyTopicsBinding.bind(view)
        menuHost = requireActivity()
        navController = requireActivity().findNavController(R.id.parent_container)
        appBarConfiguration = AppBarConfiguration(navController.graph)

        showOnBackButton()
        addMenuProvider()


    }

    private fun addMenuProvider() {
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                if (menu.hasVisibleItems()) {
                    menu.clear()
                }
                menuInflater.inflate(R.menu.menu_top_my_topics, menu)
            }


            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.action_top_my_topics -> {
                        navigateToNewTopicFragment()
                        return true
                    }
                    else -> true


                } }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun showOnBackButton() {
        (activity as AppCompatActivity).setupActionBarWithNavController(
            navController,
            appBarConfiguration
        )
    }

    private fun navigateToNewTopicFragment() {

        navController.navigate(R.id.action_myTopicsFragment_to_newTopicFragment)
       // navController.navigate(MyTopicsFragmentDirections.actionMyTopicsFragmentToNewTopicFragment())
    }
}