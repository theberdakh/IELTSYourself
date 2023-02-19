package com.theberdakh.ieltsyourself.core.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.theberdakh.ieltsyourself.core.data.local.word.WordDao
import com.theberdakh.ieltsyourself.core.data.local.word.WordDatabase
import com.theberdakh.ieltsyourself.core.domain.model.Word

class WordEditViewModel(application: Application): AndroidViewModel(application) {

    private val dao: WordDao

    init {
        dao = WordDatabase.getInstance(application).getWordDao()

    }

    suspend fun updateWord(word: Word){
        dao.updateWord(word)
    }

    suspend fun deleteWord(word: Word){
        dao.deleteWord(word)
    }
}