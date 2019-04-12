package com.alorma.animals.onboarding.presentation

sealed class OnBoardingStep {
    object Name: OnBoardingStep()
    //object Picture: OnBoardingStep()
    object Type: OnBoardingStep()
    //object Race: OnBoardingStep()
}