package com.alorma.animals.onboarding.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.alorma.animals.R
import com.alorma.animals.onboarding.presentation.OnBoardingStep
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

        onBoardingViewModel.step.observe(this, Observer {
            it?.let { onStep(it) }
        })

        onBoardingViewModel.onInit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, OnBoardingAnimalTypeFragment().apply {
                onSelectedTypeListener = onBoardingViewModel::onSelectType
            })
            .commit()
    }

    private fun onStep(it: OnBoardingStep) {
        val fragment = when (it) {
            OnBoardingStep.Name -> OnBoardingAnimalNameFragment().apply {
                onNameListener = onBoardingViewModel::onName
            }
            is OnBoardingStep.Type -> OnBoardingAnimalTypeFragment.newInstance(it.name)
                .apply {
                    onSelectedTypeListener = onBoardingViewModel::onSelectType
                }
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}