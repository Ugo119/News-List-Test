package com.ugo.pastel.persistence.manager

import co.windly.limbo.utility.reactive.subscribeOnIo
import com.ugo.pastel.persistence.database.dao.NewsDao
import com.ugo.pastel.persistence.database.entity.NewsEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.annotations.SchedulerSupport
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
@SchedulerSupport(value = SchedulerSupport.IO)
class NewsPersistenceManager  @Inject constructor(
    private val newsDao: NewsDao
) {

    fun removeAllUsers(): Completable =
        newsDao.clearTable()
            .subscribeOnIo()

    fun insert(users: List<NewsEntity>): Completable =
        newsDao
            .insert(users)
            .subscribeOnIo()

    fun insertIgnoreConflict(news: List<NewsEntity>): Completable =
        newsDao
            .insertIgnoreConflict(news)
            .subscribeOnIo()

    fun observeNews(): Flowable<List<NewsEntity>> =
        newsDao
            .observeNews()
            .subscribeOnIo()
}