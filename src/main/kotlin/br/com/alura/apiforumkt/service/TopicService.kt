package br.com.alura.apiforumkt.service

import org.springframework.stereotype.Service

@Service
class TopicService {

    fun list(): String {
        return "list of topics..."
    }

    fun findById(id: Long): String {
        return "topic of $id..."
    }

}