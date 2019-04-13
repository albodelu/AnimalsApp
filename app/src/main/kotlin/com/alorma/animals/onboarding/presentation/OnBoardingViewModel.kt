package com.alorma.animals.onboarding.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alorma.animals.domain.AnimalsRepository
import com.alorma.animals.domain.model.CreateAnimal
import com.alorma.animals.domain.model.FormField
import com.alorma.animals.navigation.Navigator
import com.alorma.animals.navigation.commands.animalsListCommand
import kotlinx.coroutines.launch

class OnBoardingViewModel(
    private val navigator: Navigator.ActivityNavigator,
    private val animalsRepository: AnimalsRepository
) : ViewModel() {

    private lateinit var createAnimal: CreateAnimal

    private val _stepLiveData: MutableLiveData<OnBoardingStep> = MutableLiveData()
    val step: LiveData<OnBoardingStep>
        get() = _stepLiveData

    fun onInit() {
        viewModelScope.launch {
            _stepLiveData.postValue(OnBoardingStep.Name)
        }
    }

    fun onName(name: String) {
        viewModelScope.launch {
            createAnimal = CreateAnimal(name)
            _stepLiveData.postValue(OnBoardingStep.Type(name))
        }
    }

    fun onSelectType(idValue: FormField.IdValue) {
        viewModelScope.launch {
            createAnimal.type = idValue.id
            animalsRepository.addAnimal(createAnimal)
            navigator.navigate(animalsListCommand())
        }
    }
}