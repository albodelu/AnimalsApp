package com.alorma.animals.onboarding.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private val _formValuesLiveData: MutableLiveData<List<FormField>> = MutableLiveData()
    val formValues: LiveData<List<FormField>>
        get() = _formValuesLiveData

    fun onInit() {
        viewModelScope.launch {
            val formFields = formRepository.getFormFields()
            _formValuesLiveData.postValue(formFields)
        }
    }
}