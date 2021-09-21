package br.com.alura.apiforumkt.repository

import br.com.alura.apiforumkt.model.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TopicRepository : JpaRepository<Topic, Long> {

    fun findAllByCourseName(courseName: String, pagination: Pageable): Page<Topic>

}