package com.theberdakh.ieltsyourself.core.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.theberdakh.ieltsyourself.core.data.local.word.WordDao
import com.theberdakh.ieltsyourself.core.data.local.word.WordDatabase
import com.theberdakh.ieltsyourself.core.domain.model.Word
import kotlinx.coroutines.flow.MutableSharedFlow

class SearchViewModel(application: Application): AndroidViewModel(application) {

    private val wordDao: WordDao
    var searchFlow = MutableSharedFlow<List<Word>>()

    init {
        wordDao = WordDatabase.getInstance(application).getWordDao()

    }

    suspend fun getAllWords(){
        searchFlow.emit(wordDao.getAllWords())
    }

    suspend fun searchAllWords(searchValue: String){
        val formattedValue = "%$searchValue%"
        searchFlow.emit(wordDao.searchAllWords(formattedValue))
    }
}