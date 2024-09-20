package com.keypartner.crud.repository

import com.keypartner.crud.model.TennisPlayer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TennisPlayerRepository: JpaRepository<TennisPlayer, Int>