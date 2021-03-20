package com.tamastudy.tamatutorial.repositories.post

import com.querydsl.jpa.impl.JPAQueryFactory
import com.tamastudy.tamatutorial.entities.PostEntity
import com.tamastudy.tamatutorial.entities.QPostEntity
import org.springframework.stereotype.Repository

@Repository
class CustomPostRepositoryImpl(
    private var queryFactory: JPAQueryFactory
) : CustomPostRepository {

    override fun getPosts_querydsl(): List<PostEntity> {
        return queryFactory.selectFrom(QPostEntity.postEntity).fetch()
    }
}