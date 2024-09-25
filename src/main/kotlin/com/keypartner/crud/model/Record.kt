package com.keypartner.crud.model

import jakarta.persistence.*

@Entity
@Table(name = "record")
data class Record(
    @Id
    @SequenceGenerator(name = "record_gen", sequenceName = "record_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "record_gen", strategy = GenerationType.AUTO)
    val id: Int,

    val wins: Int,

    val losses: Int,

    @Column(name = "grand_slams")
    val grandSlams: Int,

    @OneToOne(cascade = [ CascadeType.ALL ], fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    val player: TennisPlayer
)