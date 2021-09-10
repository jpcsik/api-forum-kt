package br.com.alura.apiforumkt.repository

import br.com.alura.apiforumkt.model.Topic
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TopicRepository: JpaRepository<Topic, Long> {

}