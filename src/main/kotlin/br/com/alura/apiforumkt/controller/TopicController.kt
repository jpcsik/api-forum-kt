package br.com.alura.apiforumkt.controller

import br.com.alura.apiforumkt.dto.NewTopicRequest
import br.com.alura.apiforumkt.dto.UpdateTopicRequest
import br.com.alura.apiforumkt.service.TopicService
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import java.net.URI
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun list(
        @RequestParam(required = false) courseName: String?,
        @PageableDefault(size = 10) pagination: Pageable
    ): ResponseEntity<Any> {
        return ResponseEntity.ok(service.list(courseName, pagination))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Any> {
        return ResponseEntity.ok(service.findById(id))
    }

    @PostMapping
    @Transactional
    fun create(@RequestBody @Valid dto: NewTopicRequest): ResponseEntity<Any> {
        val newTopic = service.create(dto)
        return ResponseEntity.created(URI.create("/topic/${newTopic.id}")).build()
    }

    @PutMapping("/{id}")
    @Transactional
    fun update(@PathVariable id: Long, @RequestBody @Valid dto: UpdateTopicRequest): ResponseEntity<Any> {
        return ResponseEntity.ok(service.update(id, dto))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }

}