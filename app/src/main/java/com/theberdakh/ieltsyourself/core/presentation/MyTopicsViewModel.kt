package com.theberdakh.ieltsyourself.core.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.theberdakh.ieltsyourself.core.data.local.topic.TopicDao
import com.theberdakh.ieltsyourself.core.data.local.topic.TopicDatabase
import com.theberdakh.ieltsyourself.core.domain.model.Topic
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow

class MyTopicsViewModel(application: Application) : AndroidViewModel(application) {

    private var dao: TopicDao
    val myTopicsFlow = MutableSharedFlow<List<Topic>>()

    init {
        dao = TopicDatabase.getInstance(application).getTopicDao()

    }

    suspend fun getAllMyTopics() {
        myTopicsFlow.emit(dao.getAllMyTopics())
    }

}