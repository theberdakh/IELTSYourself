package com.theberdakh.ieltsyourself.core.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.theberdakh.ieltsyourself.core.data.local.topic.TopicDao
import com.theberdakh.ieltsyourself.core.data.local.topic.TopicDatabase
import com.theberdakh.ieltsyourself.core.data.local.word.WordDao
import com.theberdakh.ieltsyourself.core.data.local.word.WordDatabase
import com.theberdakh.ieltsyourself.core.domain.model.Topic
import com.theberdakh.ieltsyourself.core.domain.model.Word
import kotlinx.coroutines.flow.MutableSharedFlow

class TopicEditViewModel(application: Application) : AndroidViewModel(application) {

    private val topicDao: TopicDao
    private val wordDao: WordDao

    init {
        topicDao = TopicDatabase.getInstance(application).getTopicDao()
        wordDao = WordDatabase.getInstance(application).getWordDao()
    }

    suspend fun updateTopic(topic: Topic) {
        topicDao.updateTopic(topic)
    }

    suspend fun deleteTopic(topic: Topic){
        topicDao.deleteTopic(topic)
    }

    suspend fun deleteTopicWithWords(topic: Topic){
        topicDao.deleteTopic(topic)
        wordDao.deleteWordsByTopicId(topicId = topic.id)
    }


}