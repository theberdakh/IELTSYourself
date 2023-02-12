package com.theberdakh.ieltsyourself.ui.word

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.databinding.DialogWordTranslateBinding

class WordTranslateDialog: DialogFragment(R.layout.dialog_word_translate) {
    private lateinit var binding: DialogWordTranslateBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DialogWordTranslateBinding.bind(view)
        
    }

}