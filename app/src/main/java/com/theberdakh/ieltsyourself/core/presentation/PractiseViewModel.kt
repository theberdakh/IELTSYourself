package com.theberdakh.ieltsyourself.core.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.theberdakh.ieltsyourself.core.data.local.word.WordDao
import com.theberdakh.ieltsyourself.core.data.local.word.WordDatabase
import com.theberdakh.ieltsyourself.core.domain.model.Topic
import com.theberdakh.ieltsyourself.core.domain.model.Word
import kotlinx.coroutines.flow.MutableSharedFlow

class PractiseViewModel(application: Application): AndroidViewModel(application) {

    private val wordDao: WordDao
    var practiseFlow = MutableSharedFlow<List<Word>>()

    init {
        wordDao = WordDatabase.getInstance(application).getWordDao()
    }

    suspend fun getAllWordsByTopicId(topic: Topic){
        practiseFlow.emit(wordDao.getWordsByTopicId(topic.id))
    }
}