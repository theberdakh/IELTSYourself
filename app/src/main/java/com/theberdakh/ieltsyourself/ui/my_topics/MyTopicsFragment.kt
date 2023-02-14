package com.theberdakh.ieltsyourself.ui.my_topics

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.databinding.FragmentMyTopicsBinding

class MyTopicsFragment : Fragment(R.layout.fragment_my_topics) {
    private lateinit var binding: FragmentMyTopicsBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        (activity as AppCompatActivity).actionBar?.setHomeButtonEnabled(true)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMyTopicsBinding.bind(view)
        val menuHost = requireActivity()



        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                if (menu.hasVisibleItems()) {
                    menu.clear()
                }
                menuInflater.inflate(R.menu.menu_top_my_topics, menu)
            }



            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                 when(menuItem.itemId){
                    R.id.action_add_new_topic -> {
                        navigateToNewTopicFragment()
                    }


                }
                return true
            }

        })


        navController = requireActivity().findNavController(R.id.parent_container)

        binding.apply {
        }


    }

    private fun navigateToNewTopicFragment() {

    }
}