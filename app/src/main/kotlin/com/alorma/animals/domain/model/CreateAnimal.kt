package com.alorma.animals.domain.model

data class CreateAnimal(
    val name: String
) {
    lateinit var type: String
}