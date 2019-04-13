package com.alorma.animals.animalslist.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alorma.animals.domain.AnimalFormRepository
import com.alorma.animals.domain.AnimalsRepository
import kotlinx.coroutines.launch

class AnimalsListViewModel(
    private val animalsRepository: AnimalsRepository,
    private val animalFormRepository: AnimalFormRepository,
    private val mapper: AnimalsViewModelMapper
): ViewModel() {

    fun onInit() {
        viewModelScope.launch {
            val animals = animalsRepository.getAnimals()
            val formFields = animalFormRepository.getAnimalTypeFormFields()
            val viewModels = mapper.map(animals, formFields)

            Log.i("Alorma", "Animals:")
            viewModels.forEach {
                Log.i("Alorma", it.toString())
            }
        }
    }
}