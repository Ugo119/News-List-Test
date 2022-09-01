package com.ugo.pastel.domain.manager

import android.util.Log
import com.ugo.pastel.domain.mapper.NewsMapper
import com.ugo.pastel.domain.model.base.Meta
import com.ugo.pastel.domain.model.user.News
import com.ugo.pastel.network.manager.NewsNetworkManager
import com.ugo.pastel.persistence.manager.NewsPersistenceManager
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class NewsDomainManager @Inject constructor(
    private val mapper: NewsMapper,
    private val network: NewsNetworkManager,
    private val persistence: NewsPersistenceManager
) {

    // region Download and Save Github Users

    fun downloadNewsArticles(
        location: String,
        page: String,
    ): Single<Meta> =
        network
            .getNewsArticles(location, page)
            .flatMap {

                // Map entities.
                val entities =
                    mapper.mapNewsDtoToNewsEntity(it.articles)
//                    mapper.mapDtoListToEntityList(it.articles)
                Log.e("TAG_DOMAIN", "Entities: $entities")

                val meta =
                    mapper.mapPageDtoToDomain(it)

                // Save and return page metadata.
                persistence
                    .insertIgnoreConflict(entities)
                    .toSingleDefault(meta)
            }

    // endregion

    //region Users - Observe

    fun observeNews(): Flowable<List<News>> =
        persistence
            .observeNews()
            .map(mapper::mapEntityListToDomainList)

    //endregion

    // region Delete All Users From DB

    fun deleteAllUsers(): Completable =
        persistence
            .removeAllUsers()


    // endregion

}