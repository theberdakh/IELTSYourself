package com.theberdakh.ieltsyourself.core.data.local.word

import androidx.room.Dao
import androidx.room.Query
import com.theberdakh.ieltsyourself.core.domain.model.Word
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {

    @Query("SELECT * from ${Word.TABLE_NAME}")
    suspend fun getAllWords(): Flow<List<Word>>

}