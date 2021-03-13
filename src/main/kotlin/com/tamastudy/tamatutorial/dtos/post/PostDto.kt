package com.tamastudy.tamatutorial.dtos.post

import org.hibernate.validator.constraints.Length
import java.time.LocalDateTime
import java.util.*
import javax.validation.constraints.NotBlank

data class PostDto(
    var id: Long? = null,
    var title: String? = null,
    var content: String? = null,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null,
)


// title : "" -> NotNull -> 통과
// title : "" -> NotBlank -> 통과X

data class CreatePostDto(
    @field:NotBlank
    @field:Length(min = 4, max = 20)
    var title: String? = null,
    @field:NotBlank
    @field:Length(min = 4, max = 255)
    var content: String? = null
)

data class UpdatePostDto(
    @field:Length(min = 4, max = 20)
    var title: String? = null,
    @field:Length(min = 4, max = 255)
    var content: String? = null
)