package com.keypartner.crud.model

import jakarta.persistence.*

@Entity
data class Tournament(
    @Id
    @SequenceGenerator(name = "tournament_gen", sequenceName = "tournament_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "tournament_gen", strategy = GenerationType.AUTO)
    val id: Int,

    val name: String,

    @Column(name = "prize_money")
    val prizeMoney: Int,

    @OneToMany
    val participants: List<TennisPlayer>
)