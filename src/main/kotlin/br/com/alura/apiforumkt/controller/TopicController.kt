package br.com.alura.apiforumkt.controller

import br.com.alura.apiforumkt.service.TopicService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun list(): String {
        return service.list()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): String {
        return service.findById(id)
    }

}