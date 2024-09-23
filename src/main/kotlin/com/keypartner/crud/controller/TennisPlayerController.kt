package com.keypartner.crud.controller

import com.keypartner.crud.model.TennisPlayer
import com.keypartner.crud.service.TennisPlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kp/crud/tennisplayers")
class TennisPlayerController(@Autowired private val service: TennisPlayerService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createTennisPlayer(@RequestBody player: TennisPlayer): Int = service.insert(player)

    @GetMapping
    fun getTennisPlayers(): List<TennisPlayer> = service.selectAll()

    @GetMapping("/{id}")
    fun getTennisPlayerById(@PathVariable id: Int) = service.selectById(id)

    @PatchMapping("/{id}")
    fun updateTennisPlayerRanking(@PathVariable id: Int, @RequestParam ranking: Int) =
        service.updateRanking(id, ranking)
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTennisPlayer(@PathVariable id: Int) = service.delete(id)


    @ExceptionHandler(NoSuchElementException::class)
    fun handleNoSuchElementException(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)
}