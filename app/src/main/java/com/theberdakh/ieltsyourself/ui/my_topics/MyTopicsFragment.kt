package com.theberdakh.ieltsyourself.ui.my_topics

import android.app.Activity
import android.os.Bundle
import android.view.*
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
import com.theberdakh.ieltsyourself.core.domain.model.Topic
import com.theberdakh.ieltsyourself.databinding.FragmentMyTopicsBinding
import com.theberdakh.ieltsyourself.ui.main.MainFragmentDirections
import com.theberdakh.ieltsyourself.utils.makeToast

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

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)


    }

    private fun addFragmentMenuProvider() {

        val menuHost2 = requireActivity()

        menuHost2.addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                if (menu.hasVisibleItems()) {
                    menu.clear()
                }
                menuInflater.inflate(R.menu.menu_top_my_topics, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem)= when (menuItem.itemId) {
                R.id.action_top_my_topics -> {
                    makeToast("Item clicked")
                    navigateToNewTopicFragment()
                    true
                }
                else -> false
            }

        })
    }

    private fun addMenuProvider() {
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                if (menu.hasVisibleItems()) {
                    menu.clear()
                }
                menuInflater.inflate(R.menu.menu_top_my_topics, menu)
            }


            override fun onMenuItemSelected(menuItem: MenuItem) = when (menuItem.itemId) {
                    R.id.action_top_my_topics -> {
                        makeToast("Item clicked")
                        navigateToNewTopicFragment()
                         true
                    }
                    else -> {
                        makeToast("Clicked")
                        false
                    }
                }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun showOnBackButton() {
        (activity as AppCompatActivity).setupActionBarWithNavController(
            navController,
            appBarConfiguration
        )
    }

    private fun navigateToNewTopicFragment() {
        navController.navigate(MyTopicsFragmentDirections.actionMyTopicsFragmentToNewTopicFragment())
    }
}