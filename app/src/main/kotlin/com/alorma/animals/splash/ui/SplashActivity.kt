package com.alorma.animals.splash.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alorma.animals.splash.presentation.SplashViewModel
import com.alorma.animals.splash.presentation.loadSplashModule
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class SplashActivity : AppCompatActivity() {

    private val splashViewModel: SplashViewModel by viewModel {
        parametersOf(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadSplashModule()

        splashViewModel.onInit()
    }
}