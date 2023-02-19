package com.theberdakh.ieltsyourself.ui.search

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.tabs.TabLayoutMediator
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.core.presentation.SearchViewModel
import com.theberdakh.ieltsyourself.databinding.FragmentSearchBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class SearchFragment : Fragment(R.layout.fragment_search) {
    private lateinit var binding: FragmentSearchBinding
    private var _adapter: SearchAdapter? = null
    private val adapter get() = _adapter!!
    private lateinit var navController: NavController
    private lateinit var viewModel: SearchViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchBinding.bind(view)
        _adapter = SearchAdapter()
        navController = Navigation.findNavController(requireActivity(), R.id.parent_container)
        viewModel = ViewModelProvider(requireActivity())[SearchViewModel::class.java]

        initObservers()

        binding.rvSearch.adapter = adapter

        initSearchBar()

    }

    private fun initSearchBar() {
        binding.tbSearch.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_search_words -> {
                    val searchView = menuItem.actionView as SearchView
                    searchView.queryHint = getString(R.string.title_search)
                    searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                        override fun onQueryTextSubmit(query: String?): Boolean {
                            if (query != null) {
                                lifecycleScope.launchWhenResumed {
                                    viewModel.searchAllWords(query)
                                }
                            } else {
                                lifecycleScope.launchWhenResumed {
                                    viewModel.getAllWords()
                                }
                            }
                            return false
                        }

                        override fun onQueryTextChange(newText: String?): Boolean {
                            if (newText != null) {
                                lifecycleScope.launchWhenResumed {
                                    viewModel.searchAllWords(newText)
                                }
                            } else {
                                lifecycleScope.launchWhenResumed {
                                    viewModel.getAllWords()
                                }
                            }
                            return false
                        }

                    })
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun initObservers() {
        lifecycleScope.launchWhenResumed {
            viewModel.getAllWords()
        }
        viewModel.searchFlow.onEach {
            adapter.submitList(it)
        }.launchIn(lifecycleScope)
    }
}