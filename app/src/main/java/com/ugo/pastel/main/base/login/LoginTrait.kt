package com.ugo.pastel.main.base.login

import androidx.navigation.fragment.findNavController
import co.windly.limbo.mvvm.trait.FragmentNavigationTrait
import com.ugo.pastel.NavMainDirections

interface LoginTrait :
    LoginNavigationTrait

// region Navigation

interface LoginNavigationTrait : FragmentNavigationTrait {

    fun navigateToForgotPassword()

    fun navigateToDatPlace() {
        navigationTrait
            .findNavController()
            .navigate(NavMainDirections.actionPlaces())
    }
}

// endregion
