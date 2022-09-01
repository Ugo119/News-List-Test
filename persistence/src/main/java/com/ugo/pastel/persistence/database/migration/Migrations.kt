package com.ugo.pastel.persistence.database.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

object Migrations {

    // region 1 -> 2

    private val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL(
                """CREATE TABLE IF NOT EXISTS news (
    `author`TEXT NOT NULL,
    `title` TEXT NOT NULL,
    `description` TEXT NOT NULL,
    `url` TEXT NOT NULL,
    `urlToImage` TEXT NOT NULL,
    `publishedAt` TEXT NOT NULL,
    `content` TEXT NOT NULL,
    PRIMARY KEY(`id`)
                    )""".trimIndent()
            )
        }
    }

    // endregion

    // region 2 -> 3
    // endregion

    // region All

    val ALL_MIGRATIONS = arrayOf<Migration>(
        MIGRATION_1_2,
    )

    // endregion

}
