package com.keypartner.crud.service

import com.keypartner.crud.model.TennisPlayer
import com.keypartner.crud.repository.TennisPlayerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TennisPlayerService(@Autowired val repository: TennisPlayerRepository) {

    fun selectAll(): List<TennisPlayer> = repository.findAll()

    fun selectById(id: Int): TennisPlayer = repository.findById(id).get()

    fun insert(player: TennisPlayer) = repository.save(player)

    fun updateRanking(id: Int, ranking: Int) {
        val player = repository.findById(id).get()
        repository.save(player.copy(currentRanking = ranking))
    }

    fun delete(id: Int) = repository.deleteById(id)
}