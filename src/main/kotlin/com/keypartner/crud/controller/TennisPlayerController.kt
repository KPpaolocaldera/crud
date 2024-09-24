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

    @Operation(
        summary = "Add tennis player",
        description = "Add a new tennis player to the rankings.",
        tags = ["tennis-players"]
    )
    @ApiResponses(
        ApiResponse(responseCode = "201", description = "Created", content = [ Content(
            mediaType = "application/json", contentSchema = Schema(implementation = Identifier::class),
            examples = [ExampleObject(value = "{\"id\": 1}")] )
        ]),
        ApiResponse(responseCode = "400", description = "Bad Request", content = [ Content(mediaType = "text/plain") ]),
        ApiResponse(responseCode = "500", description = "Internal Server Error", content = [ Content(mediaType = "text/plain") ])
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createTennisPlayer(@RequestBody player: TennisPlayer): Identifier = service.insert(player)

    @Operation(
        summary = "Get rankings",
        description = "Retrieve all the tennis players with their data and rankings.",
        tags = ["tennis-players"]
    )
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "OK", content = [ Content(
            mediaType = "application/json", array = ArraySchema(schema = Schema(implementation = TennisPlayer::class)),
            examples = [ExampleObject(value = "[\n" +
                    "  {\n" +
                    "    \"id\": 0,\n" +
                    "    \"name\": \"string\",\n" +
                    "    \"surname\": \"string\",\n" +
                    "    \"country\": \"string\",\n" +
                    "    \"age\": 0,\n" +
                    "    \"isRightHanded\": true,\n" +
                    "    \"currentRanking\": 0\n" +
                    "  }\n" +
                    "]")] )
        ]),
        ApiResponse(responseCode = "400", description = "Bad Request", content = [ Content(mediaType = "text/plain") ]),
        ApiResponse(responseCode = "500", description = "Internal Server Error", content = [ Content(mediaType = "text/plain") ])
    )
    @GetMapping
    fun getTennisPlayers(): List<TennisPlayer> = service.selectAll()

    @Operation(
        summary = "Get tennis player info",
        description = "Retrieve the information of a specific tennis player in the rankings.",
        tags = ["tennis-players"]
    )
    @GetMapping("/{id}")
    fun getTennisPlayerById(@PathVariable id: Int) = service.selectById(id)

    @Operation(
        summary = "Update ranking",
        description = "Update the ranking of a specific tennis player.",
        tags = ["tennis-players"]
    )
    @PatchMapping("/{id}")
    fun updateTennisPlayerRanking(@PathVariable id: Int, @RequestParam ranking: Int) =
        service.updateRanking(id, ranking)

    @Operation(
        summary = "Remove tennis player",
        description = "Remove a tennis player from the rankings.",
        tags = ["tennis-players"]
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTennisPlayer(@PathVariable id: Int) = service.delete(id)


    @ExceptionHandler(NoSuchElementException::class)
    fun handleNoSuchElementException(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)
}