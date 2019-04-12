package com.alorma.animals

import com.alorma.animals.resources.ResourceProvider
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val coreModule = module(override = true) {
    factory { ResourceProvider(androidContext()) }
}