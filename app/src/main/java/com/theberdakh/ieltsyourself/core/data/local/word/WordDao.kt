package com.theberdakh.ieltsyourself.core.data.local.word

import androidx.room.*
import com.theberdakh.ieltsyourself.core.domain.model.Word
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {

    @Query("SELECT * from ${Word.TABLE_NAME}")
    suspend fun getAllWords(): List<Word>

    @Query("SELECT * from ${Word.TABLE_NAME} WHERE is_saved = 1")
    suspend fun getAllSavedWords(): List<Word>

    @Query("SELECT * FROM ${Word.TABLE_NAME} WHERE name LIKE :searchValue")
    suspend fun searchAllWords(searchValue: String): List<Word>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addWord(word: Word)

    @Delete
    suspend fun deleteWord(word: Word)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateWord(word: Word)



}