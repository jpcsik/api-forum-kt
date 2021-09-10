package br.com.alura.apiforumkt.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Topic(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val title: String,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    val course: Course,

    @ManyToOne
    val author: User,

    @Enumerated(value = EnumType.STRING)
    val status: TopicStatus = TopicStatus.UNANSWERED,

    @OneToMany(mappedBy = "topico")
    val answers: List<Answer> = ArrayList()
)