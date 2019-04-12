package com.alorma.animals.onboarding.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alorma.animals.domain.FormRepository
import com.alorma.animals.domain.model.FormField
import com.alorma.animals.navigation.Navigator
import kotlinx.coroutines.launch

class OnBoardingViewModel(
    private val formRepository: FormRepository,
    navigator: Navigator.ActivityNavigator
) : ViewModel() {

    private lateinit var formFields: List<FormField>

    fun onInit() {
        viewModelScope.launch {
            formFields = formRepository.getFormFields()
        }
    }

    fun onTypeSelected(selectedType: FormField.IdValue) {
        Log.i("alorma-selectedtype", "SelectedType: $selectedType")
    }

    fun onTypeClick(block: (it: FormField.Selector) -> Unit) {
        formFields.filterIsInstance(FormField.Selector::class.java)
            .firstOrNull { it.id == "type" }?.let {
                block(it)
            }
    }
}