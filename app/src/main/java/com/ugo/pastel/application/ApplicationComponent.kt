package com.ugo.pastel.application

import co.windly.limbo.dagger.scope.ApplicationScope
import com.ugo.pastel.MainModule
import com.ugo.pastel.domain.DomainComponent
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@ApplicationScope
@Component(
    dependencies = [DomainComponent::class],
    modules = [
        AndroidInjectionModule::class,
        ApplicationModule::class,
        MainModule::class,
    ]
)
interface ApplicationComponent: AndroidInjector<Pastel> {

    //region Component Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun seedInstance(application: Pastel): Builder

        fun seedInstance(component: DomainComponent): Builder

        fun build(): ApplicationComponent
    }
}