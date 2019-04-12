package com.alorma.animals.splash.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alorma.animals.domain.AppRepository
import com.alorma.animals.navigation.NavigationOptions
import com.alorma.animals.navigation.Navigator
import com.alorma.animals.navigation.commands.dashboardCommand
import com.alorma.animals.navigation.commands.onBordingCommand
import kotlinx.coroutines.launch

class SplashViewModel(
    private val appRepository: AppRepository,
    private val navigator: Navigator
) : ViewModel() {

    fun onInit() {
        viewModelScope.launch {
            val isOnBoardingDone = appRepository.isOnBoardingDone()

            val command = if (isOnBoardingDone.not()) {
                onBordingCommand()
            } else {
                dashboardCommand()
            }

            navigator.navigate(command, NavigationOptions.WithFinish)
        }
    }
}