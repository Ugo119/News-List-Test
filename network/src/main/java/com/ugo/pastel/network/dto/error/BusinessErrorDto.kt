package com.ugo.pastel.network.dto.error

import com.edukoya.app.utility.network.definition.BusinessError
import com.google.gson.annotations.SerializedName
import com.ugo.pastel.utility.vocabulary.NONE
import java.util.*

data class BusinessErrorDto(

    //region Code

    @SerializedName("code")
    var code: Int = 0,

    //endregion

    //region Result

    @BusinessError
    @SerializedName("resultKey")
    var resultKey: String = String.NONE,

    @SerializedName("resultParams")
    var resultParams: List<String> = emptyList(),

    //endregion

    //region Timestamp

    @SerializedName("timestamp")
    var timestamp: Date

    //endregion
)
