package br.com.alura.apiforumkt.service

import br.com.alura.apiforumkt.dto.NewTopicRequest
import br.com.alura.apiforumkt.dto.TopicResponse
import br.com.alura.apiforumkt.dto.UpdateTopicRequest
import br.com.alura.apiforumkt.exception.NotFoundException
import br.com.alura.apiforumkt.model.Topic
import br.com.alura.apiforumkt.repository.CourseRepository
import br.com.alura.apiforumkt.repository.TopicRepository
import br.com.alura.apiforumkt.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicService(
    private val topicRepository: TopicRepository,
    private val courseRepository: CourseRepository,
    private val userRepository: UserRepository
) {

    fun list(): List<TopicResponse> {
        return topicRepository.findAll().map { TopicResponse(it) }
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

        val author = if (userRepository.findById(dto.userId).isPresent) userRepository.getById(dto.userId)
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