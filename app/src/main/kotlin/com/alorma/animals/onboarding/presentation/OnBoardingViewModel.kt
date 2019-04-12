package com.alorma.animals.onboarding.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alorma.animals.domain.model.FormField
import com.alorma.animals.navigation.Navigator
import kotlinx.coroutines.launch

class OnBoardingViewModel(
    navigator: Navigator.ActivityNavigator
) : ViewModel() {

    private lateinit var formFields: List<FormField>

    fun onInit() {
        viewModelScope.launch {

        }
    }

    fun onSelectType(idValue: FormField.IdValue) {
        Log.i("Alorma-SelectType", "Select type: $idValue")
    }
}