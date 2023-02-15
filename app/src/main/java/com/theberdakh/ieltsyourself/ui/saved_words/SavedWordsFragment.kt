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
    private lateinit var menuHost: FragmentActivity
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSavedWordsBinding.bind(view)
        menuHost = requireActivity()
        navController = requireActivity().findNavController(R.id.parent_container)

        addMenuProvider()
        setAppBarTitle()

    }

    private fun setAppBarTitle() {
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.saved_words)
    }

    private fun addMenuProvider() {
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                if (menu.hasVisibleItems()) {
                    menu.clear()
                }
                menuInflater.inflate(R.menu.menu_top_saved_words, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                 when (menuItem.itemId) {
                    R.id.action_add_saved_words -> {
                        makeToast("Menu Item selected")
                        navController.navigate(SavedWordsFragmentDirections.actionSavedWordsFragmentToNewWordFragment())

                    }
                }
                return true
            }
        })
    }
}