package br.com.alura.apiforumkt.service

import br.com.alura.apiforumkt.dto.NewTopicRequest
import br.com.alura.apiforumkt.dto.TopicResponse
import br.com.alura.apiforumkt.model.Topic
import org.springframework.stereotype.Service

@Service
class TopicService {

    fun list(): List<String> {
        return listOf("topic 1", "topic 2")
    }

    fun findById(id: Long): String {
        return "topic of $id..."
    }

    fun create(topic: NewTopicRequest): String {
        return "creating $topic"
    }

}