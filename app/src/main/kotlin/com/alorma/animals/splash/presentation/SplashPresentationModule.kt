package com.alorma.animals.splash.presentation

import android.app.Activity
import com.alorma.animals.navigation.Navigator
import com.alorma.animals.coreModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun loadSplashModule() {
    loadKoinModules(coreModule, splashPresentationModule)
}

val splashPresentationModule = module {
    viewModel { (activity: Activity) ->
        val navigator = Navigator.ActivityNavigator(activity)
        SplashViewModel(navigator)
    }
}