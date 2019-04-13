package com.alorma.animals.onboarding.presentation

import android.app.Activity
import com.alorma.animals.coreModule
import com.alorma.animals.data.dataModule
import com.alorma.animals.domain.domainModule
import com.alorma.animals.navigation.Navigator
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun loadOnBoardingModule() {
    loadKoinModules(coreModule, dataModule, domainModule, onBoardingPresentationModule)
}

val onBoardingPresentationModule = module(override = true) {
    viewModel { (activity: Activity) ->
        val navigator = Navigator.ActivityNavigator(activity)
        OnBoardingViewModel(navigator, get())
    }
}