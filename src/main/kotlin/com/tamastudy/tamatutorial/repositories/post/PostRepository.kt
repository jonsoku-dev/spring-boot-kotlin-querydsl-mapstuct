package com.tamastudy.tamatutorial.repositories.post

import com.tamastudy.tamatutorial.entities.PostEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PostRepository : JpaRepository<PostEntity, Long>, CustomPostRepository {
}