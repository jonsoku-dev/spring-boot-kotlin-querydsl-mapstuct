package com.tamastudy.tamatutorial.mappers

import com.tamastudy.tamatutorial.dtos.post.PostDto
import com.tamastudy.tamatutorial.entities.PostEntity

interface BaseMapper<E, D> {
    fun toDto(postEntity: PostEntity): PostDto
    fun toDtos(postEntities: List<PostEntity>): List<PostDto>

    fun toEntity(postDto: PostDto): PostEntity
    fun toEntities(postDtos: List<PostDto>): List<PostEntity>
}