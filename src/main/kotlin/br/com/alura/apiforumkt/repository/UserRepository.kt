package br.com.alura.apiforumkt.repository

import br.com.alura.apiforumkt.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long> {

}