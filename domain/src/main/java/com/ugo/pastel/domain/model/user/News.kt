package com.ugo.pastel.domain.model.user

import com.ugo.pastel.domain.model.source.Source
import com.ugo.pastel.utility.vocabulary.NONE

data class News(
    var author: String = String.NONE,
    var title: String = String.NONE,
    var description: String = String.NONE,
    var url: String = String.NONE,
    var urlToImage: String = String.NONE,
    var publishedAt: String = String.NONE,
    var content: String = String.NONE,
)
