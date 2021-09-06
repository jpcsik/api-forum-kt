package br.com.alura.apiforumkt.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class UpdateTopicRequest(
    @field:NotBlank(message = "title must not be blank")
    @field:Size(min = 5, max = 100, message = "title must have between 5 and 100 characters ")
    val title: String,

    @field:NotBlank(message = "message must not be blank")
    val message: String
)
