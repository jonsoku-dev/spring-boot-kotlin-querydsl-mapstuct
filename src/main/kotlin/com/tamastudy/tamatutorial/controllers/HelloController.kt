package com.tamastudy.tamatutorial.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class HelloController {
    @GetMapping("/v1/hello")
    fun hello(): ResponseEntity<Unit> {
        return ResponseEntity.noContent().build<Unit>()
    }
}