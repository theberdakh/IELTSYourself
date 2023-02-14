package com.theberdakh.ieltsyourself.core.data.local.word

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.theberdakh.ieltsyourself.core.domain.model.Word

abstract class WordDatabase: RoomDatabase() {

    abstract fun getWordDao(): WordDao

    companion object{
        private const val DB_NAME = "words"

        @Volatile
        private var INSTANCE: WordDatabase? = null

        fun getInstance(context: Context): WordDatabase {
            val tempInstance = INSTANCE
            if (tempInstance!=null) return tempInstance

            val instance = Room.databaseBuilder(context.applicationContext,
            WordDatabase::class.java, DB_NAME)
                .build()

            INSTANCE= instance
            return instance

        }


    }
}