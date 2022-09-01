package com.ugo.pastel.network.manager

import com.ugo.pastel.network.dto.NewsDto
import com.ugo.pastel.network.dto.base.PageDto
import com.ugo.pastel.network.service.NewsApi
import io.reactivex.Single
import javax.inject.Inject

class NewsNetworkManager @Inject constructor(
    private val api: NewsApi
) {
    fun getNewsArticles(location: String, apiKey: String): Single<PageDto> =
        api.getNewsArticles(location, apiKey)
}