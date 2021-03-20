package com.tamastudy.tamatutorial.mappers

import com.tamastudy.tamatutorial.dtos.post.CreatePostDto
import com.tamastudy.tamatutorial.dtos.post.PostDto
import com.tamastudy.tamatutorial.dtos.post.UpdatePostDto
import com.tamastudy.tamatutorial.entities.PostEntity
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.ReportingPolicy
import org.mapstruct.factory.Mappers

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface PostMapper: BaseMapper<PostEntity, PostDto> {
    companion object {
        val INSTANCE = Mappers.getMapper(PostMapper::class.java)
    }
    fun toEntityCreatePostDto(createPostDto: CreatePostDto): PostEntity
    fun toEntityUpdatePostDto(updatePostDto: UpdatePostDto): PostEntity
}

// val newPostEntity = ...
// val newPostDto = PostMapper.INSTANCE.toDto(newPostEntity)

// val postEntities = ...
// val postDtos = PostMapper.INSTANCE.toDtos(postEntities)