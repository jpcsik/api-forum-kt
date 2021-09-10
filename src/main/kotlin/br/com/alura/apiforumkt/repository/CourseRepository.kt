package br.com.alura.apiforumkt.repository

import br.com.alura.apiforumkt.model.Course
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseRepository: JpaRepository<Course, Long> {

}