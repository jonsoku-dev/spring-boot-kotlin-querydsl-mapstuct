package com.tamastudy.tamatutorial.entities

import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name = "post")
data class PostEntity(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    var id: Long? = null,
    var title: String? = null,
    var content: String? = null,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null
)