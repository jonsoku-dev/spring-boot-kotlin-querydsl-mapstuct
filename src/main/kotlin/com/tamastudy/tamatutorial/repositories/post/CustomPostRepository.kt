package com.tamastudy.tamatutorial.repositories.post

import com.tamastudy.tamatutorial.entities.PostEntity

interface CustomPostRepository {
    fun getPosts_querydsl(): List<PostEntity>
}