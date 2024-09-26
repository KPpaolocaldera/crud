package com.keypartner.crud.service

import com.keypartner.crud.model.Identifier
import com.keypartner.crud.model.TennisPlayer
import com.keypartner.crud.repository.TennisPlayerRepository
import com.keypartner.crud.service.filter.TennisPlayerFilter
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TennisPlayerService(@Autowired val repository: TennisPlayerRepository) {

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    fun selectAll(name: String?, surname: String?, ranking: Int?): List<TennisPlayer> =
        repository.findAll(TennisPlayerFilter().applyFindAllFilters(name, surname, ranking))


    fun selectById(id: Int): TennisPlayer = repository.findById(id).orElseThrow {
        throw NoSuchElementException("No element found with id $id.")
    }

    fun insert(player: TennisPlayer): Identifier {
        val insertedPlayer = repository.save(player)
        return Identifier(insertedPlayer.id)
    }

    fun updateRanking(id: Int, ranking: Int): TennisPlayer {
        val player = repository.findById(id).orElseThrow {
            throw NoSuchElementException("No element found with id $id.")
        }
        return repository.save(player.copy(currentRanking = ranking))
    }

    fun delete(id: Int) {
        repository.findById(id).orElseThrow {
            throw NoSuchElementException("No element found with id $id.")
        }
        repository.deleteById(id)
    }


    /**
     * selectAll() first example, exploiting the JpaRepository interface functions findBy()
     *      This is not the best approach: as long as the number of query parameters grows, we need to define a function
     *      for every possible combination
     */
//    fun selectAll(
//        name: String?,
//        surname: String?,
//        ranking: Int?
//    ): List<TennisPlayer> {
//        return when {
//            !name.isNullOrBlank() && !surname.isNullOrBlank() && ranking != null ->
//                repository.findByNameAndSurnameAndCurrentRanking(name, surname, ranking)
//            !name.isNullOrBlank() && !surname.isNullOrBlank() -> repository.findByNameAndSurname(name, surname)
//            !name.isNullOrBlank() && ranking != null -> repository.findByNameAndCurrentRanking(name, ranking)
//            !surname.isNullOrBlank() && ranking != null -> repository.findBySurnameAndCurrentRanking(surname, ranking)
//            !name.isNullOrBlank() -> repository.findByName(name)
//            !surname.isNullOrBlank() -> repository.findBySurname(surname)
//            ranking != null -> repository.findByCurrentRanking(ranking)
//            else -> repository.findAll()
//        }
//    }


    /**
     * selectAll() second example, exploiting the CriteriaBuilder class
     *      The approach has a unique drawback: all the logic stays inside the service class, which should not be
     *      the right place where to apply the query to the database.
     */
//    fun selectAll(
//        name: String?,
//        surname: String?,
//        ranking: Int?
//    ): List<TennisPlayer> {
//        val builder = entityManager.criteriaBuilder
//        val query = builder.createQuery(TennisPlayer::class.java)
//        val entity = query.from(TennisPlayer::class.java)
//
//        query.select(entity)
//
//        val predicates = mutableListOf<Predicate>()
//
//        if (!name.isNullOrBlank()) predicates.add(builder.equal(entity.get<String>("name"), name))
//        if (!surname.isNullOrBlank()) predicates.add(builder.equal(entity.get<String>("surname"), surname))
//        if (ranking != null) predicates.add(builder.equal(entity.get<Int>("currentRanking"), ranking))
//
//        query.where(*predicates.toTypedArray())
//
//        return entityManager.createQuery(query).resultList
//    }
}