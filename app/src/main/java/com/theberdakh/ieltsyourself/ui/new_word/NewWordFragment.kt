package com.theberdakh.ieltsyourself.ui.new_word

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.common.io.Resources
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.databinding.FragmentNewWordBinding

class NewWordFragment : Fragment(R.layout.fragment_new_word) {
    private lateinit var binding: FragmentNewWordBinding
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewWordBinding.bind(view)
        navController = Navigation.findNavController(requireActivity(), R.id.parent_container)


        setUpMoreFieldsToggle()
        setUpToolbar()

    }

    private fun setUpMoreFieldsToggle() {
        binding.apply {
          tilNewWordTranslation.isVisible = false
            tilNewWordExample.isVisible  = false
            var toggle = false
            tvNewWordMoreFields.apply {
                setOnClickListener {
                    if (!toggle){
                        setCompoundDrawablesWithIntrinsicBounds(
                            0,
                            0,
                            R.drawable.round_keyboard_arrow_down_24,
                            0
                        )
                        toggle = true
                        tilNewWordTranslation.isVisible = true
                        tilNewWordExample.isVisible = true

                    }
                    else {
                        setCompoundDrawablesWithIntrinsicBounds(
                            0,
                            0,
                            R.drawable.round_keyboard_arrow_right_24,
                            0
                        )
                        toggle = false
                        tilNewWordTranslation.isVisible = false
                        tilNewWordExample.isVisible = false
                    }
                }
            }

        }}


        private fun setUpToolbar() {
            binding.tbNewWord.apply {
                setNavigationOnClickListener {
                    navController.popBackStack()
                }

                setOnMenuItemClickListener { menuItem ->
                    when (menuItem.itemId) {
                        R.id.action_add_new_word -> {

                            true
                        }
                        else -> {
                            false
                        }
                    }
                }
            }
        }

    }