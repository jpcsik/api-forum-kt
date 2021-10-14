package br.com.alura.apiforumkt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class ApiForumKtApplication

fun main(args: Array<String>) {
	runApplication<ApiForumKtApplication>(*args)
}
