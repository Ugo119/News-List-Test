package com.ugo.pastel.presentation.userdetails

import androidx.navigation.fragment.findNavController
import co.windly.limbo.mvvm.trait.FragmentNavigationTrait
import com.ugo.pastel.MainActivity

//region Places

interface UserDetailsTrait: PracticeDrawerTrait
//FragmentTrait
interface PracticeDrawerTrait : FragmentNavigationTrait {

    fun openDrawer() {
        (fragmentTrait.activity as? MainActivity)?.openDrawer()
    }

    override fun navigateUp() {

        // Pop current fragment.
        navigationTrait
            .findNavController()
            .navigateUp()
    }

}

//endregion