package com.theberdakh.ieltsyourself.core.data.local.word

import androidx.room.*
import com.theberdakh.ieltsyourself.core.domain.model.Word
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {

    @Query("SELECT * from words")
    suspend fun getAllWords(): List<Word>

    @Query("SELECT * from words WHERE is_saved = 1")
    suspend fun getAllSavedWords(): List<Word>

    @Query("SELECT * FROM words WHERE name LIKE :searchValue")
    suspend fun searchAllWords(searchValue: String): List<Word>

    @Query("SELECT * FROM words WHERE topic = :topicId")
    suspend fun getWordsByTopicId(topicId: Int): List<Word>

    @Insert
    suspend fun addWord(word: Word)

    @Delete
    suspend fun deleteWord(word: Word)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateWord(word: Word)



}