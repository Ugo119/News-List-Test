package com.ugo.pastel.persistence.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ugo.pastel.persistence.database.dao.NewsDao
import com.ugo.pastel.persistence.database.entity.NewsEntity

@Database(
    version = 1,
    exportSchema = true,
    entities = [
        NewsEntity::class,
    ]
)
abstract class AndroidDatabase : RoomDatabase() {
    //region Dao

    abstract fun newsDao(): NewsDao

    //endregion
}
