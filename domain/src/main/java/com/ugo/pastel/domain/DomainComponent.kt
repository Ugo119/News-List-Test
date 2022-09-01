package com.ugo.pastel.domain

import android.content.Context
import android.content.res.Resources
import com.ugo.pastel.domain.manager.NewsDomainManager
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Component(modules = [DomainModule::class])
@Singleton
interface DomainComponent {

    //region Component Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun seedInstance(context: Context): Builder

        @BindsInstance
        fun seedInstance(resources: Resources): Builder

        fun build(): DomainComponent
    }

    //endregion

    //region Share Managers

    fun userManager(): NewsDomainManager
//
//    fun subjectDomainManager(): SubjectsDomainManager

    //endregion
}
