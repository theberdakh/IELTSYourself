package com.theberdakh.ieltsyourself.core.data.repository

import com.theberdakh.ieltsyourself.core.data.local.topic.TopicDao
import com.theberdakh.ieltsyourself.core.domain.model.Topic
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow

class TopicRepository(private val dao: TopicDao) {

    val topicFlow = MutableSharedFlow<List<Topic>>()

    suspend fun getAllTopics() = flow {
        emit(dao.getAllTopics())
    }

    suspend fun getAllStartedTopics() = flow {
        emit(dao.getAllStartedTopics())
    }

    suspend fun getAllLearnedTopics() = flow {
        emit(dao.getAllLearnedTopics())
    }


    suspend fun addTopic(topic: Topic)  {
        dao.addNewTopic(topic)
    }

    suspend fun deleteTopic(topic: Topic){
        dao.deleteTopic(topic)
    }

    suspend fun updateTopic(topic: Topic){
        dao.updateTopic(topic)
    }

}