package com.theberdakh.ieltsyourself.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.theberdakh.ieltsyourself.R
import com.theberdakh.ieltsyourself.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}