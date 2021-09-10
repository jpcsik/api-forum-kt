package br.com.alura.apiforumkt.dto

import br.com.alura.apiforumkt.model.Topic
import br.com.alura.apiforumkt.model.TopicStatus
import java.time.LocalDateTime

data class TopicResponse(private val topic: Topic){
    val id = topic.id
    val title = topic.title
    val message = topic.message
    val status = topic.status
    val createdAt = topic.createdAt
}
