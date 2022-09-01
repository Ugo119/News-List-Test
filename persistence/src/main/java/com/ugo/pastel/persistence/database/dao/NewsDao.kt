package com.ugo.pastel.persistence.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ugo.pastel.persistence.database.entity.NewsEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
abstract class NewsDao : BaseDao<NewsEntity>(){

    @Query(value = "DELETE FROM news")
    abstract fun clearTable(): Completable

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insertIgnoreConflict(entities: List<NewsEntity>): Completable

//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    abstract fun insertIgnoreConflict(entity: NewsEntity): Single<Long>

    @Query(value = "SELECT * FROM news")
    abstract fun observeNews(): Flowable<List<NewsEntity>>

}