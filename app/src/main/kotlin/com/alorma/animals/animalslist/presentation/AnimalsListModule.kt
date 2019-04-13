package com.alorma.animals.animalslist.presentation

import com.alorma.animals.coreModule
import com.alorma.animals.data.dataModule
import com.alorma.animals.domain.domainModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun loadAnimalsModule() {
    loadKoinModules(coreModule, dataModule, domainModule, animalsListPresentationModule)
}

val animalsListPresentationModule = module(override = true) {
    viewModel { AnimalsListViewModel(get(), get(named("create_animal")), get()) }
    factory { AnimalsViewModelMapper(get(named("animal_created_date"))) }
}