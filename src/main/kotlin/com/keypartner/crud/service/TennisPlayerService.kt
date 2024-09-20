package com.keypartner.crud.service

import com.keypartner.crud.model.TennisPlayer
import com.keypartner.crud.repository.TennisPlayerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TennisPlayerService(@Autowired val repository: TennisPlayerRepository) {

    fun getAll(): List<TennisPlayer> = repository.findAll()

    fun insert(player: TennisPlayer) = repository.save(player)

    fun delete(id: Int) = repository.deleteById(id)
}