package com.theberdakh.ieltsyourself.core.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.theberdakh.ieltsyourself.core.domain.model.Word.Companion.TABLE_NAME
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = TABLE_NAME)
data class Word(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(Companion.name)
    val name: String,
    @ColumnInfo(Companion.meaning)
    val meaning: String,
    @ColumnInfo(Companion.translation)
    val translation: String,
    @ColumnInfo(Companion.example)
    val example: String,

    @ColumnInfo(Companion.topic)
    val topic: Int,
    @ColumnInfo(Companion.level)
    val level: Int,
    @ColumnInfo(Companion.isNoun)
    val isNoun: Int,
    @ColumnInfo(Companion.isVerb)
    val isVerb: Int,
    @ColumnInfo(Companion.isAdjective)
    val isAdjective: Int,
    @ColumnInfo(Companion.isAdverb)
    val isAdverb: Int,
    @ColumnInfo(Companion.isPhrasalVerb)
    val isPhrasalVerb: Int,
    @ColumnInfo(Companion.isPhrasalNoun)
    val isPhrasalNoun: Int,
    @ColumnInfo(Companion.isIdiom)
    val isIdiom: Int,

    @ColumnInfo(isFavorite)
    val is_saved: Int = 0,
    @ColumnInfo(isSearched)
    val searched: Int = 0,
    @ColumnInfo(Companion.listening)
    val listening: Int = 0,
    @ColumnInfo(Companion.reading)
    val reading: Int = 0,
    @ColumnInfo(Companion.writing)
    val writing: Int = 0,
    @ColumnInfo(Companion.speaking)
    val speaking: Int = 0
) : Parcelable {
    companion object {

        /*
        * Constant parameters of database and its fields
        **/
        const val TABLE_NAME = "words"
        const val name = "name"
        const val meaning = "meaning"
        const val translation = "translation"
        const val example = "example"
        const val topic = "topic"
        const val level = "level"
        const val isNoun = "is_n"
        const val isVerb = "is_v"
        const val isAdjective = "is_adj"
        const val isAdverb = "is_adv"
        const val isPhrasalVerb = "is_pv"
        const val isPhrasalNoun = "is_pn"
        const val isIdiom = "is_i"
        const val isFavorite = "is_favorite"
        const val isSearched = "is_searched"
        const val listening = "listening"
        const val reading = "reading"
        const val writing = "writing"
        const val speaking = "speaking"


        /*
        * Dynamic parameters
        **/
        val SAVED = 1 //When word is saved
        val LEARNED = 1 //When word is learned in listening, reading, and writing
        val SEARCHED = 1 //When word is searched
    }
}
