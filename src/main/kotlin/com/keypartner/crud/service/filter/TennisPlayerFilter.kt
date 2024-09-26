package com.keypartner.crud.service.filter

import com.keypartner.crud.model.TennisPlayer
import org.springframework.data.jpa.domain.Specification

class TennisPlayerFilter {

    fun applyFindAllFilters(
        name: String?,
        surname: String?,
        ranking: Int?
    ): Specification<TennisPlayer> = Specification.allOf(
        filterByName(name),
        filterBySurname(surname),
        filterByRanking(ranking)
    )

    private fun filterByName(name: String?): Specification<TennisPlayer> =
        Specification<TennisPlayer> { entity, _, builder ->
            if (!name.isNullOrBlank()) builder.equal(entity.get<String>("name"), name) else null
        }

    private fun filterBySurname(surname: String?): Specification<TennisPlayer> =
        Specification<TennisPlayer> { entity, _, builder ->
            if (!surname.isNullOrBlank()) builder.equal(entity.get<String>("surname"), surname) else null
        }

    private fun filterByRanking(ranking: Int?): Specification<TennisPlayer> =
        Specification<TennisPlayer> { entity, _, builder ->
            if (ranking != null) builder.equal(entity.get<Int>("currentRanking"), ranking) else null
        }
}