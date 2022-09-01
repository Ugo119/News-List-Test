package com.ugo.pastel.presentation.auth.login

import com.ugo.pastel.main.base.login.BaseLoginViewModel
import com.ugo.pastel.utility.validation.UgoWierd
import com.ugo.pastel.utility.validation.error.ErrorResources
import com.ugo.pastel.utility.validation.local.LocalResources
import javax.inject.Inject

@Suppress("MaxLineLength", "LongParameterList")
class LoginViewModel @Inject constructor(
    ugoWierd: UgoWierd,
    errorResources: ErrorResources,
    localResources: LocalResources,
) : BaseLoginViewModel(
    ugoWierd,
    errorResources,
    localResources,
)