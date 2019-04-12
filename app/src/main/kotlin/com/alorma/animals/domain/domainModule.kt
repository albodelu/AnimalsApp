package com.alorma.animals.domain

import com.alorma.animals.data.AppRepositoryImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module

val domainModule = module(override = true) {
    factory<AppRepository>{ AppRepositoryImpl(get()) }

    factory<FormRepository>(named("create_animal")){ CreateAnimalFormRepository() }
}