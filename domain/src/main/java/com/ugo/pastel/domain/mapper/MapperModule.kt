package com.ugo.pastel.domain.mapper

import dagger.Module
import dagger.Provides
import org.mapstruct.factory.Mappers
import javax.inject.Singleton

@Module
class MapperModule {


    //region News

    @Provides
    @Singleton
    internal fun provideUserMapper(): NewsMapper =
        Mappers
            .getMapper(NewsMapper::class.java)

    //endregion

}
