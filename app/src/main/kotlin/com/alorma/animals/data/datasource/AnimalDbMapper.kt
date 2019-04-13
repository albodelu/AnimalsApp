package com.alorma.animals.data.datasource

import com.alorma.animals.domain.model.CreateAnimal
import com.alorma.animals.resources.TimeProvider
import java.util.*

class AnimalDbMapper(private val timeProvider: TimeProvider) {

    fun mapCreateAnimal(createAnimal: CreateAnimal): CreateAnimalDaoModel = CreateAnimalDaoModel(
        UUID.randomUUID().toString(),
        createAnimal.name,
        createAnimal.type,
        timeProvider.now()
    )

}