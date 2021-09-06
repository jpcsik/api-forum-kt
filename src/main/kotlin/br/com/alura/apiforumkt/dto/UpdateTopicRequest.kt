package br.com.alura.apiforumkt.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class UpdateTopicRequest(
    @field:NotBlank @field:Size(min = 5, max = 100) val title: String,
    @field:NotBlank val message: String
)
