package com.alorma.animals

import com.alorma.animals.resources.ResourceProvider
import com.alorma.animals.resources.TimeProvider
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import java.text.SimpleDateFormat
import java.util.*

val coreModule = module(override = true) {
    factory { ResourceProvider(androidContext()) }
    factory { TimeProvider() }

    factory(named("animal_created_date")) {
        SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    }
}