package com.theberdakh.ieltsyourself.core.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Lifecycle
import com.theberdakh.ieltsyourself.core.data.local.topic.TopicDao
import com.theberdakh.ieltsyourself.core.data.local.topic.TopicDatabase
import com.theberdakh.ieltsyourself.core.data.repository.TopicRepository
import com.theberdakh.ieltsyourself.core.domain.model.Topic
import kotlinx.coroutines.flow.MutableSharedFlow

class NewTopicViewModel(application: Application) : AndroidViewModel(application) {
    private var topicDao: TopicDao
    private var repository: TopicRepository

    init {
        topicDao = TopicDatabase.getInstance(application).getTopicDao()
        repository = TopicRepository(topicDao)
    }

    val topicFlow = MutableSharedFlow<Topic>()

    suspend fun addNewTopic(topic: Topic)  {
         topicDao.addNewTopic(topic)
    }
}