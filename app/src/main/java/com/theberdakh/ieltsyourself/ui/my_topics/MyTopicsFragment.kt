package com.theberdakh.ieltsyourself.ui.my_topics

import android.app.Activity
import android.os.Bundle
import android.view.*
import androidx.activity.OnBackPressedCallback
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMyTopicsBinding.bind(view)
        navController = requireActivity().findNavController(R.id.parent_container)

        binding.apply {


            tbMyTopics.setNavigationOnClickListener{
                navController.popBackStack()
            }

            tbMyTopics.setOnMenuItemClickListener {menuItem->
                 when(menuItem.itemId){
                    R.id.action_top_my_topics -> {
                        navigateToNewTopicFragment()
                        makeToast("Ok")
                        true
                    }
                     else -> {false}
                 }
            }
        }

    }




    private fun navigateToNewTopicFragment() {
        navController.navigate(MyTopicsFragmentDirections.actionMyTopicsFragmentToNewTopicFragment())
    }
}