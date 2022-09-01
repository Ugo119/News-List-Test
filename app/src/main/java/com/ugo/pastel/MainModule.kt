package com.ugo.pastel

import androidx.lifecycle.ViewModel
import co.windly.limbo.dagger.ViewModelKey
import com.ugo.pastel.presentation.PresentationModule
import com.ugo.pastel.presentation.auth.login.LoginModule
import com.ugo.pastel.presentation.auth.register.CreateNewAccountModule
import com.ugo.pastel.presentation.auth.welcome.WelcomeModule
import com.ugo.pastel.presentation.places.PlacesModule
import com.ugo.pastel.presentation.userdetails.UserDetailsModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module(
    includes = [
        PlacesModule::class,
        WelcomeModule::class,
        CreateNewAccountModule::class,
        LoginModule::class,
        PresentationModule::class,
        UserDetailsModule::class,
    ]
)
abstract class MainModule {

    //region Binding

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    //endregion

    //region Contribution

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    //endregion

    //region View Model Factory

//    @Binds
//    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    //endregion

}
