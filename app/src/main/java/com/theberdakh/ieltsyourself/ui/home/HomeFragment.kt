package com.theberdakh.ieltsyourself.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.core.domain.model.Game
import com.theberdakh.ieltsyourself.core.domain.model.Topic
import com.theberdakh.ieltsyourself.core.domain.model.objects.Games
import com.theberdakh.ieltsyourself.databinding.FragmentHomeBinding
import com.theberdakh.ieltsyourself.ui.main.MainFragmentDirections

class HomeFragment: Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var navController: NavController
    private var _adapter: HomeRecyclerAdapter? = null
    private val adapter get() = _adapter!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        _adapter = HomeRecyclerAdapter()
        navController = Navigation.findNavController(requireActivity(), R.id.parent_container)


        adapter.submitList(Games.getGames())
        binding.rvHome.adapter = adapter

        adapter.setOnCardClickedListener { game->
            navigateToTopicsFragment(game)
        }

        adapter.setOnPractiseClickedListener {

        }


    }

    private fun navigateToTopicsFragment(game: Game) {
       // navController.navigate()
    }
}