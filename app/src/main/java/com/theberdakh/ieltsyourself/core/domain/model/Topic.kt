package com.theberdakh.ieltsyourself.core.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "topics")
data class Topic(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("description")
    val description: String = "",
    @ColumnInfo( "level")
    val level: Int = 0,
    @ColumnInfo("size")
    var size: Int = 0,
    @ColumnInfo("status")
    val status: Int = 0,
    @ColumnInfo( "image")
    val image: String = "0",
): Parcelable
