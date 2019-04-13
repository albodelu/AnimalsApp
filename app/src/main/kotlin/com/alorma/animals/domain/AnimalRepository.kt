package com.alorma.animals.domain

import com.alorma.animals.domain.model.CreateAnimal

interface AnimalRepository {
    suspend fun hasAnimals(): Boolean
    suspend fun addAnimal(createAnimal: CreateAnimal)
}