package com.theberdakh.ieltsyourself.ui.sign_in

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.databinding.FragmentSignInBinding

class SignInFragment: Fragment(R.layout.fragment_sign_in) {
    private lateinit var binding:FragmentSignInBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignInBinding.bind(view)
        setAppBarTitle()

    }

    private fun setAppBarTitle() {
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.sign_in)
    }
}