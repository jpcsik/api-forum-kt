package br.com.alura.apiforumkt.dto

import br.com.alura.apiforumkt.model.Course
import br.com.alura.apiforumkt.model.Topic
import br.com.alura.apiforumkt.model.Author
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class NewTopicRequest(
    @field:NotBlank(message = "title must not be blank")
    @field:Size(min = 5, max = 100, message = "title must have between 5 and 100 characters ")
    val title: String,

    @field:NotBlank(message = "message must not be blank")
    val message: String,

    @field:NotNull(message = "courseId must not be null")
    val courseId: Long,

    @field:NotNull(message = "userId must not be null")
    val userId: Long,
) {

    fun toModel(course: Course, user: Author): Topic {
        return Topic(
            title = this.title,
            message = this.message,
            course = course,
            author = user
        )

    }
}
