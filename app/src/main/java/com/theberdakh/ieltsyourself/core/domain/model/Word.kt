package com.theberdakh.ieltsyourself.core.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "words")
data class Word(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("meaning")
    val meaning: String,
    @ColumnInfo("translation")
    val translation: String? =null ,
    @ColumnInfo("example")
    val example: String? = null,
    @ColumnInfo("topic")
    val topic: Int,
    @ColumnInfo("is_saved")
    val isSaved: Int = 0,
    @ColumnInfo("is_searched")
    val isSearched: Int = 0,
    @ColumnInfo("status")
    val status: Int = 0
) : Parcelable
