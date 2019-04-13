package com.alorma.animals.domain

import com.alorma.animals.data.datasource.RoomAnimalDataSource
import com.alorma.animals.domain.model.Animal
import com.alorma.animals.domain.model.CreateAnimal

class AnimalsRepository(
    private val animalDataSource: RoomAnimalDataSource
) {

    suspend fun hasAnimals(): Boolean = animalDataSource.getAnimals().isNotEmpty()
    suspend fun getAnimals(): List<Animal> = animalDataSource.getAnimals()
    suspend fun addAnimal(createAnimal: CreateAnimal) = animalDataSource.addAnimal(createAnimal)
}