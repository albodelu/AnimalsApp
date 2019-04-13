package com.alorma.animals.animalslist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alorma.animals.animalslist.presentation.model.AnimalViewModel
import com.alorma.animals.domain.AnimalFormRepository
import com.alorma.animals.domain.AnimalsRepository
import kotlinx.coroutines.launch

class AnimalsListViewModel(
    private val animalsRepository: AnimalsRepository,
    private val animalFormRepository: AnimalFormRepository,
    private val mapper: AnimalsViewModelMapper
) : ViewModel() {

    private val _animalsLiveData: MutableLiveData<List<AnimalViewModel>> = MutableLiveData()
    val animals: LiveData<List<AnimalViewModel>>
        get() = _animalsLiveData

    fun onInit() {
        viewModelScope.launch {
            val animals = animalsRepository.getAnimals()
            val formFields = animalFormRepository.getAnimalTypeFormFields()
            val viewModels = mapper.map(animals, formFields)

            _animalsLiveData.postValue(viewModels)
        }
    }
}