package com.tamastudy.tamatutorial.entities

import javax.persistence.*


@Entity
@Table(name = "post")
data class PostEntity(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    var id: Long? = null,
    var title: String? = null,
    var content: String? = null
) : CommonDateEntity()