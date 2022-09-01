package com.ugo.pastel.domain.model.source

import co.windly.limbo.utility.primitives.EMPTY
import com.ugo.pastel.utility.vocabulary.NONE

data class Source(
    var id: String = String.NONE,
    var name: String = String.EMPTY,
)