package com.alorma.animals.onboarding.presentation

sealed class OnBoardingStep {
    object Name: OnBoardingStep()
    //object Picture: OnBoardingStep()
    data class Type(val name: String): OnBoardingStep()
    //object Race: OnBoardingStep()
}