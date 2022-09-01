package com.ugo.pastel.presentation.places

import androidx.navigation.fragment.findNavController
import co.windly.limbo.mvvm.trait.FragmentNavigationTrait
import com.ugo.pastel.MainActivity
import com.ugo.pastel.NavMainDirections
import com.ugo.pastel.domain.model.user.News

//region Places

interface PlacesTrait: PracticeDrawerTrait
//FragmentTrait
interface PracticeDrawerTrait : FragmentNavigationTrait {

    fun openDrawer() {
        (fragmentTrait.activity as? MainActivity)?.openDrawer()
    }

    fun navigateToUserDetails(news: News) {
        navigationTrait
            .findNavController()
            .navigate(NavMainDirections
                .actionUserDetails(news.url)
            )
    }

}

//endregion