package com.theberdakh.ieltsyourself.ui.choose

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.view.menu.MenuBuilder
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.core.domain.model.Game
import com.theberdakh.ieltsyourself.databinding.FragmentChooseBinding

class ChooseFragment: Fragment(R.layout.fragment_choose) {
    private lateinit var binding: FragmentChooseBinding
    private lateinit var navController: NavController
    private var _adapter: ChooseAdapter? = null
    private val adapter get() = _adapter!!
    private lateinit var game: Game

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentChooseBinding.bind(view)
        val args: ChooseFragmentArgs by navArgs()

        game = args.game
        navController = Navigation.findNavController(requireActivity(), R.id.parent_container)
        _adapter = ChooseAdapter()
        binding.apply {
            tbChoose.setNavigationOnClickListener {
                navController.popBackStack()
            }

            val contextMenu = ChooseContextMenu()

            tbChoose.createContextMenu(contextMenu)

        }


    }
}