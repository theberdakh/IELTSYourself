package com.theberdakh.ieltsyourself.core.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.theberdakh.ieltsyourself.core.data.local.topic.TopicDao
import com.theberdakh.ieltsyourself.core.data.local.topic.TopicDatabase
import com.theberdakh.ieltsyourself.core.domain.model.Topic
import kotlinx.coroutines.flow.MutableSharedFlow

class TopicsViewModel(application: Application): AndroidViewModel(application) {

    private val topicDao: TopicDao
    var topicsFlow = MutableSharedFlow<List<Topic>>()

    init {
        topicDao = TopicDatabase.getInstance(application).getTopicDao()
    }

    suspend fun getAllMyTopics(){
        topicsFlow.emit(topicDao.getAllMyTopics())
    }
}