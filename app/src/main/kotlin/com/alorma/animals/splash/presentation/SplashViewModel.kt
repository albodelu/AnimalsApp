package com.alorma.animals.splash.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alorma.animals.domain.AnimalRepository
import com.alorma.animals.navigation.NavigationOptions
import com.alorma.animals.navigation.Navigator
import com.alorma.animals.navigation.commands.dashboardCommand
import com.alorma.animals.navigation.commands.onBordingCommand
import kotlinx.coroutines.launch

class SplashViewModel(
    private val animalsRepository: AnimalRepository,
    private val navigator: Navigator
) : ViewModel() {

    fun onInit() {
        viewModelScope.launch {
            val hasAnimals = animalsRepository.hasAnimals()

            val command = if (hasAnimals.not()) {
                onBordingCommand()
            } else {
                dashboardCommand()
            }

            navigator.navigate(command, NavigationOptions.WithFinish)
        }
    }
}