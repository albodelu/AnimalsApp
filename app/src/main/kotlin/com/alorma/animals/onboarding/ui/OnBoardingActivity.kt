package com.alorma.animals.onboarding.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.alorma.animals.domain.model.FormField
import com.alorma.animals.onboarding.presentation.OnBoardingViewModel
import com.alorma.animals.onboarding.presentation.loadOnBoardingModule
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class OnBoardingActivity: AppCompatActivity() {

    private val onBoardingViewModel: OnBoardingViewModel by viewModel {
        parametersOf(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadOnBoardingModule()

        onBoardingViewModel.formValues.observe(this, Observer {
            it?.let { onFormValues(it) }
        })
        onBoardingViewModel.onInit()
    }

    private fun onFormValues(formFields: List<FormField>) {
        Toast.makeText(this, "Items: ${formFields.size}", Toast.LENGTH_SHORT).show()
    }
}