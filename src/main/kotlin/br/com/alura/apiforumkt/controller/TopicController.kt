package br.com.alura.apiforumkt.controller

import br.com.alura.apiforumkt.dto.NewTopicRequest
import br.com.alura.apiforumkt.dto.UpdateTopicRequest
import br.com.alura.apiforumkt.service.TopicService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import javax.validation.Valid
import kotlin.random.Random

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun list(): ResponseEntity<Any> {
        return ResponseEntity.ok(service.list())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Any> {
        return ResponseEntity.ok(service.findById(id))
    }

    @PostMapping
    fun create(@RequestBody @Valid topicDto: NewTopicRequest): ResponseEntity<Any> {
        service.create(topicDto)
        return ResponseEntity.created(URI.create("/topic/${Random.nextInt()}")).build()
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody @Valid topicDto: UpdateTopicRequest): ResponseEntity<Any>{
        return ResponseEntity.ok(service.update(id, topicDto))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }

}