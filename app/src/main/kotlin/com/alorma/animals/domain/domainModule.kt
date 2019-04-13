package com.alorma.animals.domain

import org.koin.core.qualifier.named
import org.koin.dsl.module

val domainModule = module(override = true) {
    factory(named("create_animal")) {
        AnimalFormRepository(get())
    }

    factory { AnimalsRepository(get()) }
}