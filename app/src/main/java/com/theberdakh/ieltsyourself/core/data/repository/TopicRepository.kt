package com.theberdakh.ieltsyourself.core.data.repository

import com.theberdakh.ieltsyourself.core.data.local.topic.TopicDao
import com.theberdakh.ieltsyourself.core.domain.model.Topic
import kotlinx.coroutines.flow.flow

class TopicRepository(private val dao: TopicDao) {

    suspend fun getAllTopic() = flow {
        emit(dao.getAllTopics())
    }


}