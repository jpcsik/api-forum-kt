package br.com.alura.apiforumkt.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class NewTopicRequest(
    @field:NotBlank @field:Size(min = 5, max = 100) val title: String,
    @field:NotBlank val message: String,
    @field:NotNull val courseId: Long,
    @field:NotNull val userId: Long,
)
