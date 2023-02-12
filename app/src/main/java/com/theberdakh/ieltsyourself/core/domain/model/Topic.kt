package com.theberdakh.ieltsyourself.core.domain.model

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.theberdakh.ieltsyourself.core.domain.model.Topic.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class Topic(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    @ColumnInfo(name = Companion.name)
    val name: String,
    @ColumnInfo(name = Topic.level)
    val level: Int,
    @ColumnInfo(name = Companion.status)
    val status: Int,
    @ColumnInfo(name = Companion.image)
    val image: Bitmap,
    @ColumnInfo(name = Companion.listening)
    val listening: Int,
    @ColumnInfo(name = Companion.reading)
    val reading: Int,
    @ColumnInfo(name = Companion.writing)
    val writing: Int,
    @ColumnInfo(name = Companion.speaking)
    val speaking: Int
) {
    companion object{
        /*
        * Constant parameters: name of the table and its fields
        * */
        const val TABLE_NAME = "topics"
        const val level = "level"
        const val image = "image"
        const val name = "name"
        const val status = "status"
        const val listening = "listening"
        const val reading = "reading"
        const val writing = "writing"
        const val speaking = "speaking"

        /*
        * Dynamic parameters
        * */
        val NOT_STARTED = 0 // Default is 0 and changes when the user begins learning
        val LEARNING = 1 // When 1, this topic appears in the Learn Fragment
        val LEARNED = 2 //When all inside words are learned, it disappears from Learn Fragment
    }
}
