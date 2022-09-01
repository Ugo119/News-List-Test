package com.ugo.pastel.network.dto

import com.google.gson.annotations.SerializedName
import com.ugo.pastel.utility.vocabulary.NONE

data class NewsDto(
    @SerializedName("source")
    var source: SourceDto? = null,
    @SerializedName("author")
    var author: String = String.NONE,
    @SerializedName("title")
    var title: String = String.NONE,
    @SerializedName("description")
    var description: String = String.NONE,
    @SerializedName("url")
    var url: String = String.NONE,
    @SerializedName("urlToImage")
    var urlToImage: String = String.NONE,
    @SerializedName("publishedAt")
    var publishedAt: String = String.NONE,
    @SerializedName("content")
    var content: String = String.NONE,
)