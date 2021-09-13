package br.com.alura.apiforumkt.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Topic(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var title: String,
    var message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    val course: Course,

    @ManyToOne
    val author: Author,

    @Enumerated(value = EnumType.STRING)
    val status: TopicStatus = TopicStatus.UNANSWERED,

    @OneToMany(mappedBy = "topic")
    val answers: List<Answer> = ArrayList()
)