package com.alorma.animals.onboarding.presentation

import com.alorma.animals.coreModule
import com.alorma.animals.data.dataModule
import com.alorma.animals.domain.domainModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun loadOnBoardingSelectTypeModule() {
    loadKoinModules(coreModule, dataModule, domainModule, onBoardingSelectTypePresentationModule)
}

val onBoardingSelectTypePresentationModule = module {
    viewModel {
        SelectTypeViewModel(get(named("create_animal")))
    }
}