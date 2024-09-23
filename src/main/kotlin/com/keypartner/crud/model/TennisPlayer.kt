package com.keypartner.crud.model

import jakarta.persistence.*

@Entity
@Table(name = "tennis_player")
data class TennisPlayer(
    @Id
    val id: Int,

    val name: String,

    val surname: String,

    val country: String,

    val age: Int,

    @Column(name = "is_right_handed")
    val isRightHanded: Boolean,

    @Column(name = "current_ranking")
    val currentRanking: Int
)