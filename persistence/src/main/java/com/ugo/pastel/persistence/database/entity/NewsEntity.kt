package com.ugo.pastel.persistence.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ugo.pastel.utility.vocabulary.NONE
import com.ugo.pastel.utility.vocabulary.ZERO

@Entity(tableName = "news")
data class NewsEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id: Long = Long.ZERO,
    @ColumnInfo(name = "author")
    var author: String = String.NONE,
    @ColumnInfo(name = "title")
    var title: String = String.NONE,
    @ColumnInfo(name = "description")
    var description: String = String.NONE,
    @ColumnInfo(name = "url")
    var url: String = String.NONE,
    @ColumnInfo(name = "urlToImage")
    var urlToImage: String = String.NONE,
    @ColumnInfo(name = "publishedAt")
    var publishedAt: String = String.NONE,
    @ColumnInfo(name = "content")
    var content: String = String.NONE,
)