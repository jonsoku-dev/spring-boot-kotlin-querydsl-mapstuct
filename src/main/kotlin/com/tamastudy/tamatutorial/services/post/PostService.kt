package com.tamastudy.tamatutorial.services.post

import com.tamastudy.tamatutorial.dtos.post.CreatePostDto
import com.tamastudy.tamatutorial.dtos.post.PostDto
import com.tamastudy.tamatutorial.dtos.post.UpdatePostDto
import java.util.*

interface PostService {
    fun getPosts(): List<PostDto>
    fun getPost(postId: Long): PostDto
    fun createPost(createPostDto: CreatePostDto)
    fun updatePost(postId: Long, updatePostDto: UpdatePostDto)
    fun deletePost(postId: Long)
}