package com.ugo.pastel.network.dto.error

import com.google.gson.annotations.SerializedName
import com.ugo.pastel.utility.vocabulary.NONE

data class ValidationErrorDto(

    //region Code

    @SerializedName("statusCode")
    var code: Int = 0,

    //endregion

    //region Code

    @SerializedName("error")
    var error: String = String.NONE,

    //endregion

    //region Field Errors

    @SerializedName("message")
    var message: String = String.NONE,

    //endregion

    //region Field Errors

    @SerializedName("messages")
    var messages: Map<String, List<String>> = emptyMap(),

    //endregion

)
