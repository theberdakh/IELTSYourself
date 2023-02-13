package com.theberdakh.ieltsyourself.core.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.theberdakh.ieltsyourself.core.data.local.topic.TopicDatabase
import com.theberdakh.ieltsyourself.core.data.repository.TopicRepository
import com.theberdakh.ieltsyourself.core.domain.model.Topic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class AddViewModel(application: Application): AndroidViewModel(application) {
    private val topicFlow: MutableSharedFlow<List<Topic>>
    private val repository: TopicRepository

    init {
        val topicDao = TopicDatabase.getInstance(application).getTopicDao()
        repository = TopicRepository(topicDao)
        topicFlow = repository.topicFlow
    }

    suspend fun getAllTopics()  {
        viewModelScope.launch(Dispatchers.IO){
            repository.getAllTopics()
        }
    }

    suspend fun deleteTopic(topic: Topic) {
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteTopic(topic)
        }
    }

    suspend fun addTopic(topic: Topic){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTopic(topic)
        }
    }

    suspend fun updateTopic(topic: Topic){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateTopic(topic)
        }
    }

    suspend fun getAllStartedTopics(){
        viewModelScope.launch(Dispatchers.IO){
            repository.getAllStartedTopics()
        }
    }

    suspend fun getAllLearnedTopics(){
        viewModelScope.launch(Dispatchers.IO){
            repository.getAllLearnedTopics()
        }
    }

}