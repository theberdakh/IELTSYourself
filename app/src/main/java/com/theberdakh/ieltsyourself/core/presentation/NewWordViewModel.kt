package com.theberdakh.ieltsyourself.core.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.theberdakh.ieltsyourself.core.data.local.topic.TopicDao
import com.theberdakh.ieltsyourself.core.data.local.topic.TopicDatabase
import com.theberdakh.ieltsyourself.core.data.local.word.WordDao
import com.theberdakh.ieltsyourself.core.data.local.word.WordDatabase
import com.theberdakh.ieltsyourself.core.domain.model.Topic
import com.theberdakh.ieltsyourself.core.domain.model.Word

class NewWordViewModel(application: Application): AndroidViewModel(application) {

    private val dao: WordDao
    private val topicDao: TopicDao


    init {
        dao = WordDatabase.getInstance(application).getWordDao()
        topicDao = TopicDatabase.getInstance(application).getTopicDao()
    }

    suspend fun addWord(word: Word){
        dao.addWord(word)
    }

    suspend fun updateTopicSize(topic: Topic){
        topicDao.updateTopic(topic.copy(size = topic.size+1))
    }

}