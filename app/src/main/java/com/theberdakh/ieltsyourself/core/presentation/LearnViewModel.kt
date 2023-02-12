package com.theberdakh.ieltsyourself.core.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.theberdakh.ieltsyourself.core.data.local.topic.TopicDao

class LearnViewModel(application: Application): AndroidViewModel(application) {
    private lateinit var dao: TopicDao

    init {

    }

}