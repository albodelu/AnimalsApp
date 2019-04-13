package com.alorma.animals.domain.model

import java.util.*

data class Animal(
    val id: String,
    val name: String,
    val type: String,
    val createdAt: Date
)