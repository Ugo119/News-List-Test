package com.ugo.pastel.network.service

import com.ugo.pastel.network.dto.NewsDto
import com.ugo.pastel.network.dto.base.PageDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines")
    fun getNewsArticles(
        @Query("country") location: String,
        @Query("apiKey") apiKey: String,
    ): Single<PageDto>
}