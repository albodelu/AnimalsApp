package com.alorma.animals.splash.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alorma.animals.domain.AnimalsRepository
import com.alorma.animals.navigation.NavigationOptions
import com.alorma.animals.navigation.Navigator
import com.alorma.animals.navigation.commands.animalsListCommand
import com.alorma.animals.navigation.commands.onBordingCommand
import kotlinx.coroutines.launch

class SplashViewModel(
    private val animalsRepository: AnimalsRepository,
    private val navigator: Navigator
) : ViewModel() {

    fun onInit() {
        viewModelScope.launch {
            val hasAnimals = animalsRepository.hasAnimals()

            val command = if (hasAnimals.not()) {
                onBordingCommand()
            } else {
                animalsListCommand()
            }

            navigator.navigate(command, NavigationOptions.WithFinish)
        }
    }
}