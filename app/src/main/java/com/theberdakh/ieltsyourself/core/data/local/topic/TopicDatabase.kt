package com.theberdakh.ieltsyourself.core.data.local.topic

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.theberdakh.ieltsyourself.core.domain.model.Topic

@Database(entities = [Topic::class], version = 1, exportSchema = true)
abstract class TopicDatabase : RoomDatabase() {

    abstract fun getTopicDao(): TopicDao

    companion object {
        @Volatile
        private var INSTANCE: TopicDatabase? = null

        fun getInstance(context: Context): TopicDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TopicDatabase::class.java,
                    "topics"
                ).build()

                INSTANCE = instance

                return instance
            }
        }
    }
}