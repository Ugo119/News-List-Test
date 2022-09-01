package com.ugo.pastel.persistence.database

import android.content.Context
import androidx.room.Room
import com.ugo.pastel.persistence.database.migration.Migrations.ALL_MIGRATIONS
import com.ugo.pastel.persistence.database.dao.NewsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    //region Dao

    @Provides
    @Singleton
    internal fun provideUserDao(database: AndroidDatabase): NewsDao =
        database.newsDao()


    //endregion

    //region Database

    @Provides
    @Singleton
    internal fun provideDatabase(context: Context): AndroidDatabase =
        Room
            .databaseBuilder(context, AndroidDatabase::class.java, Configuration.NAME)
            .addMigrations(*ALL_MIGRATIONS)
            .fallbackToDestructiveMigration()
            .build()

    //endregion

    //region Configuration

    internal object Configuration {
        internal const val NAME = "Pastel.db"
    }

    //endregion
}
