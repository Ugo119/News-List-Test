package com.ugo.pastel.domain.mapper

import co.windly.limbo.utility.mapping.ExtendedMapper
import com.ugo.pastel.domain.model.base.Meta
import com.ugo.pastel.domain.model.user.News
import com.ugo.pastel.network.dto.NewsDto
import com.ugo.pastel.network.dto.base.MetaDto
import com.ugo.pastel.network.dto.base.PageDto
import com.ugo.pastel.persistence.database.entity.NewsEntity
import org.mapstruct.*

@Mapper(
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface NewsMapper : ExtendedMapper<NewsDto, NewsEntity, News> {

    // Meta

    fun mapDtoToDomain(dto: MetaDto): Meta

    // endregion

    fun mapPageDtoToDomain(dto: PageDto): Meta

    // region

    override fun mapDtoToEntity(dto: NewsDto): NewsEntity

    // endregion

    fun mapNewsDtoToNewsEntity(dto: List<NewsDto>): List<NewsEntity>

}