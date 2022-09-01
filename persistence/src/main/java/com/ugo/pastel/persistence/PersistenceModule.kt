package com.ugo.pastel.persistence

import com.ugo.pastel.persistence.database.DatabaseModule
import dagger.Module

@Module(
    includes = [
        DatabaseModule::class
    ]
)
class PersistenceModule
