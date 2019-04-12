package com.alorma.animals.onboarding.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.lifecycle.lifecycleOwner
import com.afollestad.materialdialogs.list.listItemsSingleChoice
import com.alorma.animals.R
import com.alorma.animals.domain.model.FormField
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

        loadOnBoardingModule()

        onBoardingViewModel.formValues.observe(this, Observer {
            it?.let { onFormValues(it) }
        })
        onBoardingViewModel.onInit()
    }

    private fun onFormValues(formFields: List<FormField>) {
        formFields.filterIsInstance(FormField.Selector::class.java)
            .firstOrNull { it.id == "type" }?.let { typeField ->
                MaterialDialog(this).show {
                    title(R.string.animal_type_dialog_title)
                    lifecycleOwner(this@OnBoardingActivity)
                    val names = typeField.values.map { it.name }
                    listItemsSingleChoice(items = names) { _, index, _ ->
                        val selectedType = typeField.values[index]
                        onBoardingViewModel.onTypeSelected(selectedType)
                    }
                }
            }
    }
}