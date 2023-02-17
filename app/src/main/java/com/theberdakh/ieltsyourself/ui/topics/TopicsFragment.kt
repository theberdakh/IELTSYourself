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
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.core.domain.model.Game
import com.theberdakh.ieltsyourself.databinding.FragmentTopicsBinding

class TopicsFragment : Fragment(R.layout.fragment_topics) {

    private lateinit var binding: FragmentTopicsBinding

    private var game: Game? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: TopicsFragmentArgs by navArgs()
        game = args.game
        binding = FragmentTopicsBinding.bind(view)

        setUpToolbar()
    }

    private fun setUpToolbar() {
        binding.apply {
            tbTopics.subtitle = if (game == null) {
                getString(R.string.all_topics)
            } else {
                getString(R.string.choose_a_topic_to_practise)
            }
        }
    }

}