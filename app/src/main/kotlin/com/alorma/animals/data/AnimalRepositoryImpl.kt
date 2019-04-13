package com.alorma.animals.data

import com.alorma.animals.domain.AnimalRepository
import com.alorma.animals.domain.model.CreateAnimal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AnimalRepositoryImpl: AnimalRepository {

    override suspend fun addAnimal(createAnimal: CreateAnimal) = withContext(Dispatchers.IO) {

    }
}