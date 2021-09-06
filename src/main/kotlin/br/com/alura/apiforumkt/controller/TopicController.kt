package br.com.alura.apiforumkt.controller

import br.com.alura.apiforumkt.dto.NewTopicRequest
import br.com.alura.apiforumkt.service.TopicService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun list(): List<String> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): String {
        return service.findById(id)
    }

    @PostMapping
    fun create(@RequestBody @Valid topicDto: NewTopicRequest) {
        service.create(topicDto)
    }

}