package com.keypartner.crud.repository

import com.keypartner.crud.model.TennisPlayer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface TennisPlayerRepository: JpaRepository<TennisPlayer, Int>, JpaSpecificationExecutor<TennisPlayer> {

//    fun findByNameAndSurnameAndCurrentRanking(name: String, surname: String, ranking: Int): List<TennisPlayer>
//    fun findByNameAndSurname(name: String, surname: String): List<TennisPlayer>
//    fun findByNameAndCurrentRanking(name: String, ranking: Int): List<TennisPlayer>
//    fun findBySurnameAndCurrentRanking(surname: String, ranking: Int): List<TennisPlayer>
//    fun findByName(name: String): List<TennisPlayer>
//    fun findBySurname(surname: String): List<TennisPlayer>
//    fun findByCurrentRanking(ranking: Int): List<TennisPlayer>

}