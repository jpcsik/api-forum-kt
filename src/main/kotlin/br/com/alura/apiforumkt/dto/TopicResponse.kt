package br.com.alura.apiforumkt.dto

import br.com.alura.apiforumkt.model.TopicStatus
import java.time.LocalDateTime

data class TopicResponse(
    val id: Long,
    val title: String,
    val message: String,
    val status: TopicStatus,
    val createdAt: LocalDateTime
)
