package com.alorma.animals.onboarding.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alorma.animals.R
import com.alorma.animals.onboarding.presentation.OnBoardingViewModel
import com.alorma.animals.onboarding.presentation.loadOnBoardingModule
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class OnBoardingActivity : AppCompatActivity() {

    private val onBoardingViewModel: OnBoardingViewModel by viewModel {
        parametersOf(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding_activity)

        loadOnBoardingModule()

        onBoardingViewModel.onInit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, OnBoardingAnimalTypeFragment().apply {
                onSelectedTypeListener = onBoardingViewModel::onSelectType
            })
            .commit()
    }
}