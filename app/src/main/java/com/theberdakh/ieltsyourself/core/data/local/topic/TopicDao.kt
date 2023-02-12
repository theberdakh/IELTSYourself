package com.theberdakh.ieltsyourself.core.data.local.topic

import androidx.room.Dao
import androidx.room.Query
import com.theberdakh.ieltsyourself.core.domain.model.Topic
import kotlinx.coroutines.flow.Flow


@Dao
interface TopicDao {

    @Query("SELECT * from ${Topic.TABLE_NAME}")
    suspend fun getAllTopics(): Flow<List<Topic>>
}