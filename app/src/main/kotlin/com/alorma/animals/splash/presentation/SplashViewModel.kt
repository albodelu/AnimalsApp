package com.alorma.animals.splash.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alorma.animals.navigation.NavigationOptions
import com.alorma.animals.navigation.Navigator
import com.alorma.animals.navigation.commands.dashboardCommand
import kotlinx.coroutines.launch

class SplashViewModel(private val navigator: Navigator) : ViewModel() {

    fun onInit() {
        viewModelScope.launch {
            navigator.navigate(dashboardCommand(), NavigationOptions.WithFinish)
        }
    }
}