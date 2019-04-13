package com.alorma.animals.data

import com.alorma.animals.data.datasource.RoomAnimalDataSource
import com.alorma.animals.domain.AnimalRepository
import com.alorma.animals.domain.model.CreateAnimal

class AnimalRepositoryImpl(
    private val animalDataSource: RoomAnimalDataSource
) : AnimalRepository {

    override suspend fun addAnimal(createAnimal: CreateAnimal) = animalDataSource.addAnimal(createAnimal)
}