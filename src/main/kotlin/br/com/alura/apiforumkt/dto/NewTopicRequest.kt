package br.com.alura.apiforumkt.dto

data class NewTopicRequest(
    val title: String,
    val message: String,
    val courseId: Long,
    val userId: Long,
)
