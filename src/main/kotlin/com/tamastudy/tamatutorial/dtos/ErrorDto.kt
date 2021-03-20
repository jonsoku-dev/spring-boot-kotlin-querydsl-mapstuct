package com.tamastudy.tamatutorial.dtos

import org.springframework.http.HttpStatus

data class ErrorDto(
    val status: HttpStatus,
    var errors: MutableList<ErrorDetail>? = mutableListOf()
)

data class ErrorDetail(
    var field: String? = null,
    var message: String? = null,
    var value: Any? = null
)