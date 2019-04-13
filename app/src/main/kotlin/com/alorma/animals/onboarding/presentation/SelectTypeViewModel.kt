package com.alorma.animals.onboarding.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alorma.animals.domain.AnimalFormRepository
import com.alorma.animals.domain.model.FormField
import kotlinx.coroutines.launch

class SelectTypeViewModel(
    private val animalFormRepository: AnimalFormRepository
): ViewModel() {

    fun onRequest(block: (List<FormField.IdValue>) -> Unit) {
        viewModelScope.launch {
            block(animalFormRepository.getAnimalTypeFormFields())
        }
    }

}