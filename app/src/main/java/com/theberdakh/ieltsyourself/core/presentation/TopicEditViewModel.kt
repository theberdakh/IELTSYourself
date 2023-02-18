package com.theberdakh.ieltsyourself.core.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.theberdakh.ieltsyourself.core.data.local.topic.TopicDao
import com.theberdakh.ieltsyourself.core.data.local.topic.TopicDatabase
import com.theberdakh.ieltsyourself.core.domain.model.Topic
import kotlinx.coroutines.flow.MutableSharedFlow

class TopicEditViewModel(application: Application) : AndroidViewModel(application) {

    private val topicDao: TopicDao

    init {
        topicDao = TopicDatabase.getInstance(application).getTopicDao()
    }

    suspend fun updateTopic(topic: Topic) {
        topicDao.updateTopic(topic)
    }

    suspend fun deleteTopic(topic: Topic){
        topicDao.deleteTopic(topic)
    }

}