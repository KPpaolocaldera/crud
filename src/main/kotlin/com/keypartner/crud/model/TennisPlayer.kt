package com.keypartner.crud.model

data class TennisPlayer(
    val id: Int,
    val name: String,
    val surname: String,
    val country: String,
    val age: Int,
    val isRightHanded: Boolean,
    val currentRanking: Int
)