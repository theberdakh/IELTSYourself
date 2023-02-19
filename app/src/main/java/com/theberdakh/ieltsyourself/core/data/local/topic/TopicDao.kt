package com.theberdakh.ieltsyourself.core.data.local.topic

import androidx.room.*
import com.theberdakh.ieltsyourself.core.domain.model.Topic
import kotlinx.coroutines.flow.Flow


@Dao
interface TopicDao {

    @Query("SELECT * from topics")
    suspend fun getAllTopics(): List<Topic>

    @Query("SELECT *  from topics WHERE status = 0 ORDER BY id DESC")
    suspend fun getAllMyTopics(): List<Topic>

    @Query("SELECT * FROM topics WHERE status = 1")
    suspend fun getAllStartedTopics(): List<Topic>

    @Query("SELECT * FROM topics WHERE status = 2")
    suspend fun getAllLearnedTopics(): List<Topic>


    @Insert(Topic::class)
    suspend fun addNewTopic(topic: Topic)

    @Query("SELECT * FROM topics WHERE id = :id")
    suspend fun getTopicById(id: Int): Topic

    @Delete(entity = Topic::class)
    suspend fun deleteTopic(topic: Topic)

    @Update
    suspend fun updateTopic(topic: Topic)


}