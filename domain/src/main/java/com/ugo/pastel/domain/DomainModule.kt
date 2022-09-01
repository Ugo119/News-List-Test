package com.ugo.pastel.domain

import com.ugo.pastel.domain.mapper.MapperModule
import com.ugo.pastel.network.NetworkModule
import com.ugo.pastel.persistence.PersistenceModule
import com.ugo.pastel.utility.UtilityModule
import dagger.Module

@Module(
    includes = [
        MapperModule::class,
        NetworkModule::class,
        PersistenceModule::class,
        UtilityModule::class,
    ]
)
class DomainModule
