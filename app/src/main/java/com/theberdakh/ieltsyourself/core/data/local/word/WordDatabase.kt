package com.theberdakh.ieltsyourself.core.data.local.word

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.theberdakh.ieltsyourself.core.domain.model.Word

@Database(entities = [Word::class], version = 1, exportSchema = true)
abstract class WordDatabase: RoomDatabase() {

    abstract fun getWordDao(): WordDao

    companion object{

        @Volatile
        private var INSTANCE: WordDatabase? = null

        fun getInstance(context: Context): WordDatabase {
            val tempInstance = INSTANCE
            if (tempInstance!=null) return tempInstance

            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                    WordDatabase::class.java, "words").build()
                INSTANCE= instance
                return instance
            }


        }


    }
}