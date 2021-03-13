package com.tamastudy.tamatutorial.services.post

import com.tamastudy.tamatutorial.dtos.post.CreatePostDto
import com.tamastudy.tamatutorial.dtos.post.PostDto
import com.tamastudy.tamatutorial.dtos.post.UpdatePostDto
import com.tamastudy.tamatutorial.entities.PostEntity
import com.tamastudy.tamatutorial.repositories.post.PostRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.logging.Logger

@Service
class PostServiceImpl(
    private val postRepository: PostRepository
) : PostService {
    companion object {
        val LOG: Logger = Logger.getLogger(PostServiceImpl::class.java.name)
    }

    override fun getPosts(): List<PostDto> {
        val postEntities = postRepository.findAll()
        val postDtos = postEntities.map { postEntity ->
            PostDto().apply {
                this.id = postEntity.id
                this.title = postEntity.title
                this.content = postEntity.content
                this.createdAt = postEntity.createdAt
                this.updatedAt = postEntity.updatedAt
            }
        }
        return postDtos
    }

    override fun getPost(postId: Long): PostDto {
        return postRepository.findByIdOrNull(postId)?.let { postEntity ->
            PostDto().apply {
                this.id = postEntity.id
                this.title = postEntity.title
                this.content = postEntity.content
                this.createdAt = postEntity.createdAt
                this.updatedAt = postEntity.updatedAt
            }
        } ?: kotlin.run {
            LOG.warning("$postId 에 해당하는 포스트를 찾을 수 없습니다.")
            throw RuntimeException()
        }
    }

    override fun createPost(createPostDto: CreatePostDto) {
        // 변환 작업
        val newPost = PostEntity().apply {
            this.title = createPostDto.title
            this.content = createPostDto.content
        }.also {
            LOG.info("newPost: $it")
        }
        postRepository.save(newPost)
    }

    override fun updatePost(postId: Long, updatePostDto: UpdatePostDto) {
        val foundPost = postRepository.findByIdOrNull(postId) ?: kotlin.run {
            LOG.warning("$postId 에 해당하는 포스트를 찾을 수 없습니다.")
            throw RuntimeException()
        }

        // 변환 작업
        val newPost = foundPost.apply {
            this.title = updatePostDto.title
            this.content = updatePostDto.content
        }.also {
            LOG.info("updatedPost: $it")
        }
        postRepository.save(newPost)
    }

    override fun deletePost(postId: Long) {
        postRepository.findByIdOrNull(postId)?.let { foundPost ->
            postRepository.deleteById(foundPost.id!!)
        } ?: kotlin.run {
            LOG.warning("$postId 에 해당하는 포스트를 찾을 수 없습니다.")
            throw RuntimeException()
        }
    }
}