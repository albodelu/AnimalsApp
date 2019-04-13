package com.alorma.animals.data.datasource

import com.alorma.animals.domain.model.Animal
import com.alorma.animals.domain.model.CreateAnimal
import com.alorma.animals.resources.TimeProvider
import java.util.*

class AnimalDbMapper(private val timeProvider: TimeProvider) {

    fun mapCreateAnimal(createAnimal: CreateAnimal): AnimalDaoModel = AnimalDaoModel(
        UUID.randomUUID().toString(),
        createAnimal.name,
        createAnimal.type,
        timeProvider.now()
    )

    fun mapAnimal(animalDao: AnimalDaoModel): Animal = Animal(
        animalDao.id,
        animalDao.name,
        animalDao.type,
        Date(animalDao.createdAt)
    )
}