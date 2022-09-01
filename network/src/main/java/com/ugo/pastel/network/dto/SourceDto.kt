package com.ugo.pastel.network.dto

import co.windly.limbo.utility.primitives.EMPTY
import com.google.gson.annotations.SerializedName
import com.ugo.pastel.utility.vocabulary.NONE

data class SourceDto(
    @SerializedName("id")
    var id: String = String.NONE,
    @SerializedName("name")
    var name: String = String.EMPTY,
)