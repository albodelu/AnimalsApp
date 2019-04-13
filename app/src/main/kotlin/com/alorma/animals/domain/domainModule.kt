package com.alorma.animals.domain

import com.alorma.animals.data.AnimalRepositoryImpl
import com.alorma.animals.data.CreateAnimalFormRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val domainModule = module(override = true) {
    factory<FormRepository>(named("create_animal")) {
        CreateAnimalFormRepository(get())
    }

    factory<AnimalRepository> { AnimalRepositoryImpl(get()) }
}