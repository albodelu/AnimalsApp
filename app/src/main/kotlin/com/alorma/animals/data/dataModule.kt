package com.alorma.animals.data

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module(override = true) {
    factory { AppConfigDataSource(androidContext()) }
}