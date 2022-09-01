package com.ugo.pastel.presentation.userdetails

import android.util.Log
import co.windly.limbo.mvvm.viewmodel.LimboViewModel
import com.ugo.pastel.domain.manager.NewsDomainManager
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class UserDetailsViewModel @Inject constructor(
    private val newsDomainManager: NewsDomainManager
) : LimboViewModel() {

}