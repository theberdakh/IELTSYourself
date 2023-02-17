package com.theberdakh.ieltsyourself.ui.me

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.core.domain.model.objects.Settings
import com.theberdakh.ieltsyourself.databinding.FragmentMeBinding
import com.theberdakh.ieltsyourself.ui.main.MainFragmentDirections
import com.theberdakh.ieltsyourself.utils.makeToast

class MeFragment: Fragment(R.layout.fragment_me){
    private lateinit var binding: FragmentMeBinding
    private lateinit var navController: NavController
    private var _adapter: MeRecyclerAdapter? = null
    private val adapter: MeRecyclerAdapter get() = _adapter!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMeBinding.bind(view)

        _adapter = MeRecyclerAdapter()
        navController = requireActivity().findNavController(R.id.parent_container)

        binding.apply {
            rvMe.adapter = adapter
            adapter.submitList(Settings.getAllSettings())

            adapter.onItemClicked {
                when(it.id){
                    Settings.MY_TOPICS -> {
                        navigateToMyTopicsFragment()
                    }
                    Settings.SAVED_WORDS -> {

                    }
                }
            }

        }


    }

    private fun navigateToMyTopicsFragment() {
        navController.navigate(MainFragmentDirections.actionMainFragmentToMyTopicsFragment())
    }

}