package com.alorma.animals.onboarding.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alorma.animals.domain.model.FormField
import com.alorma.animals.navigation.Navigator
import com.alorma.animals.navigation.commands.dashboardCommand
import kotlinx.coroutines.launch

class OnBoardingViewModel(
    private val navigator: Navigator.ActivityNavigator
) : ViewModel() {

    private val _stepLiveData: MutableLiveData<OnBoardingStep> = MutableLiveData()
    val step: LiveData<OnBoardingStep>
        get() = _stepLiveData

    fun onInit() {
        viewModelScope.launch {
            _stepLiveData.postValue(OnBoardingStep.Name)
        }
    }

    fun onName(name: String) {
        _stepLiveData.postValue(OnBoardingStep.Type)
    }

    fun onSelectType(idValue: FormField.IdValue) {
        navigator.navigate(dashboardCommand())
    }
}