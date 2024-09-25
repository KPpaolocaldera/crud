package com.keypartner.crud.controller

import com.keypartner.crud.model.Identifier
import com.keypartner.crud.model.TennisPlayer
import com.keypartner.crud.service.TennisPlayerService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.ExampleObject
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.media.ArraySchema
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
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
@RequestMapping("/tennisplayers")
class TennisPlayerController(@Autowired private val service: TennisPlayerService) {

    /**
     * POST /tennisplayers
     */
    @Operation(summary = "Add tennis player", tags = ["tennis-players"])
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createTennisPlayer(@RequestBody player: TennisPlayer): Identifier = service.insert(player)


    /**
     * GET /tennisplayers
     */
    @Operation(summary = "Get rankings", tags = ["tennis-players"])
    @GetMapping
    fun getTennisPlayers(
        @RequestParam name: String?,
        @RequestParam surname: String?,
        @RequestParam ranking: Int?
    ): List<TennisPlayer> = service.selectAll(name, surname, ranking)


    /**
     * GET /tennisplayers/{id}
     */
    @Operation(summary = "Get tennis player info", tags = ["tennis-players"])
    @GetMapping("/{id}")
    fun getTennisPlayerById(@PathVariable id: Int) = service.selectById(id)


    /**
     * PATCH /tennisplayers/{id}
     */
    @Operation(summary = "Update ranking", tags = ["tennis-players"])
    @PatchMapping("/{id}")
    fun updateTennisPlayerRanking(@PathVariable id: Int, @RequestParam ranking: Int): TennisPlayer =
        service.updateRanking(id, ranking)


    /**
     * DELETE /tennisplayers/{id}
     */
    @Operation(summary = "Remove tennis player", tags = ["tennis-players"])
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTennisPlayer(@PathVariable id: Int) = service.delete(id)


    @ExceptionHandler(NoSuchElementException::class)
    fun handleNoSuchElementException(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)
}