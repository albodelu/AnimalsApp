package com.alorma.animals.data.datasource

import com.alorma.animals.domain.model.CreateAnimal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomAnimalDataSource(
    private val animalDbMapper: AnimalDbMapper,
    private val animalDao: AnimalDao
) {

    suspend fun getAnimals() = withContext(Dispatchers.IO) {
        animalDao.getAll().map {
            animalDbMapper.mapAnimal(it)
        }
    }

    suspend fun addAnimal(createAnimal: CreateAnimal) = withContext(Dispatchers.IO) {
        val animal = animalDbMapper.mapCreateAnimal(createAnimal)
        animalDao.insert(animal)
    }
}