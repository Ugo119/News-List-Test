package com.ugo.pastel.utility.network.exception

import com.ugo.pastel.utility.vocabulary.NONE

data class ValidationFieldError(

    //region Messages

    var messages: List<String> = emptyList(),

    //endregion

    //region Field

    var field: String = String.NONE

    //endregion
)