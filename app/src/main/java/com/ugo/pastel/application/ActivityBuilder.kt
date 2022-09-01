package com.ugo.pastel.application

import com.ugo.pastel.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [ApplicationModule::class])
    abstract fun bindMainActivity(): MainActivity
}