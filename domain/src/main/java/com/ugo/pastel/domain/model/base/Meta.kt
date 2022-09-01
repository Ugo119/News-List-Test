package com.ugo.pastel.domain.model.base

import co.windly.limbo.utility.primitives.EMPTY
import co.windly.limbo.utility.primitives.ZERO
import com.ugo.pastel.domain.model.user.News

data class Meta(

    var articles: MutableList<News> = mutableListOf(),

    //endregion

    //region Status

    var status: String = String.EMPTY,

    //endregion

    // region totalResults

    val totalResults: Long = Long.ZERO

    // endregion

)
