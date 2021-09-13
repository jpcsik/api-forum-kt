package br.com.alura.apiforumkt.repository

import br.com.alura.apiforumkt.model.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository: JpaRepository<Author, Long> {

}