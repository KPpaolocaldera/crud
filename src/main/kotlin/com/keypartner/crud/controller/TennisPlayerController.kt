package com.keypartner.crud.controller

import com.keypartner.crud.model.TennisPlayer
import com.keypartner.crud.service.TennisPlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kp/crud/tennisplayers")
class TennisPlayerController(@Autowired private val service: TennisPlayerService) {

    @GetMapping
    fun getTennisPlayers(): List<TennisPlayer> = service.selectAll()

    @GetMapping("/{id}")
    fun getTennisPlayerById(@PathVariable id: Int) = service.selectById(id)

    @PostMapping
    fun createTennisPlayer(@RequestBody player: TennisPlayer): Int = service.insert(player)
}