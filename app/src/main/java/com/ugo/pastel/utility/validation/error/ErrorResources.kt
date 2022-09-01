package com.ugo.pastel.utility.validation.error

import android.content.res.Resources
import com.ugo.pastel.R
import dagger.Reusable
import javax.inject.Inject

@Reusable
class ErrorResources @Inject constructor(private val resources: Resources) {

    //region Errors

    fun unknownError(): String =
        resources.getString(R.string.api_error_unknown)

    fun serverUnreachable(): String =
        resources.getString(R.string.network_server_unreachable)


    fun countryCodeError(): String =
        resources.getString(R.string.country_code_error)

    //endregion

}