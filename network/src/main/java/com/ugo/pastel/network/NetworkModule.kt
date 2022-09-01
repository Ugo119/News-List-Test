package com.ugo.pastel.network

import com.ugo.pastel.network.http.api.ApiModule
import com.ugo.pastel.network.service.NewsApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module(
    includes = [ApiModule::class])
class NetworkModule {

    //region User

    @Provides
    @Singleton
    internal fun provideUserApi(retrofit: Retrofit): NewsApi =
        retrofit.create()

    //endregion


}
