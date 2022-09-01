package com.ugo.pastel.network.dto.base

import co.windly.limbo.utility.primitives.EMPTY
import co.windly.limbo.utility.primitives.ZERO
import com.google.gson.annotations.SerializedName
import com.ugo.pastel.network.dto.NewsDto

data class PageDto(
    //region Content

    @SerializedName("articles")
    var articles: MutableList<NewsDto> = mutableListOf(),

    //endregion

    //region Status

    @SerializedName("status")
    var status: String = String.EMPTY,

    //endregion

    // region totalResults

    @SerializedName("totalResults")
    val totalResults: Long = Long.ZERO

    // endregion

)