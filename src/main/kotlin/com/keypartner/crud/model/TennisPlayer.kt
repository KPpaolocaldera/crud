package com.keypartner.crud.model

import jakarta.persistence.*

@Entity
@Table(name = "tennis_player")
data class TennisPlayer(
    @Id
    @SequenceGenerator(name = "tennis_player_gen", sequenceName = "tennis_player_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "tennis_player_gen", strategy = GenerationType.AUTO)
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