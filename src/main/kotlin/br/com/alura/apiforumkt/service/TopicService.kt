package br.com.alura.apiforumkt.service

import br.com.alura.apiforumkt.dto.NewTopicRequest
import br.com.alura.apiforumkt.dto.TopicResponse
import br.com.alura.apiforumkt.dto.UpdateTopicRequest
import br.com.alura.apiforumkt.exception.NotFoundException
import br.com.alura.apiforumkt.model.Topic
import br.com.alura.apiforumkt.repository.CourseRepository
import br.com.alura.apiforumkt.repository.TopicRepository
import br.com.alura.apiforumkt.repository.AuthorRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TopicService(
    private val topicRepository: TopicRepository,
    private val courseRepository: CourseRepository,
    private val authorRepository: AuthorRepository
) {

    fun list(courseName: String?, pagination: Pageable): Page<TopicResponse> {

        return if (courseName != null) {
            topicRepository.findAllByCourseName(courseName, pagination).map { TopicResponse(it) }
        } else {
            topicRepository.findAll(pagination).map { TopicResponse(it) }
        }

    }

    fun findById(id: Long): TopicResponse {

        val possibleTopic = topicRepository.findById(id)

        when {
            possibleTopic.isPresent -> return TopicResponse(possibleTopic.get())
            else -> throw NotFoundException("Topic not found")
        }

    }

    fun create(dto: NewTopicRequest): Topic {

        val course = if (courseRepository.findById(dto.courseId).isPresent) courseRepository.getById(dto.courseId)
        else throw NotFoundException("Course not found")

        val author = if (authorRepository.findById(dto.userId).isPresent) authorRepository.getById(dto.userId)
        else throw NotFoundException("User not found")

        return topicRepository.save(dto.toModel(course, author))

    }

    fun update(id: Long, dto: UpdateTopicRequest): TopicResponse {

        topicRepository.findById(id).let {
            if (it.isPresent) {
                it.get().title = dto.title
                it.get().message = dto.message
                return TopicResponse(it.get())
            } else throw NotFoundException("Topic not found")
        }

    }

    fun delete(id: Long) {
        topicRepository.findById(id)
            .let { if (it.isPresent) topicRepository.deleteById(id) else throw NotFoundException("Topic not found") }
    }

}