package com.alorma.animals.data

import android.content.Context
import android.preference.PreferenceManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppConfigDataSource(private val context: Context) {
    suspend fun onBoardingDone(): Boolean = withContext(context = Dispatchers.IO) {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val onBoarding = sharedPreferences.getBoolean("onboarding_done", false)
        sharedPreferences.edit().putBoolean("onboarding_done", true).apply()
        onBoarding
    }
}