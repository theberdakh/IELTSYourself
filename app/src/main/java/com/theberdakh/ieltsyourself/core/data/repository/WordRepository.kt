package com.theberdakh.ieltsyourself.core.data.repository

import com.theberdakh.ieltsyourself.core.data.local.word.WordDao
import com.theberdakh.ieltsyourself.core.domain.model.Word
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow

class WordRepository(private val dao: WordDao) {

    val wordFlow = MutableSharedFlow<List<Word>>()

    suspend fun getAllWords() = flow {
        emit(dao.getAllWords())
    }

    suspend fun getAllSavedWords() = flow {
        emit(dao.getAllSavedWords())
    }

    suspend fun updateWord(word: Word){
        dao.updateWord(word)
    }

    suspend fun deleteWord(word: Word){
        dao.deleteWord(word)
    }

    suspend fun searchWord(searchValue: String){
        //Write changes to searchValue
        dao.searchAllWords(searchValue)
    }

    suspend fun addWord(word: Word){
        dao.addWord(word)
    }

}