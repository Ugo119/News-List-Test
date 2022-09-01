package com.ugo.pastel.application

import android.content.Context
import android.content.res.Resources
import co.windly.limbo.dagger.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    @ApplicationScope
    internal fun provideApplicationContext(application: Pastel): Context =
        application

    //region Context

//    @Provides
//    @Singleton
//    internal fun provideApplicationContext(application: DatPlace): Context =
//        application

    @Provides
    internal fun provideApplicationResources(application: Pastel): Resources =
        application.resources

    //endregion

    //region Content Provider

//    @Provides
//    internal fun provideContentResolver(context: Context): ContentResolver =
//        context.contentResolver

    //endregion
}