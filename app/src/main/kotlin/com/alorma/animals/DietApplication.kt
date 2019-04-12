package com.alorma.animals

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DietApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@DietApplication)
        }
    }
}