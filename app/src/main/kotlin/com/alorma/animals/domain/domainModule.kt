package com.alorma.animals.domain

import com.alorma.animals.data.AppRepositoryImpl
import org.koin.dsl.module

val domainModule = module(override = true) {
    factory<AppRepository>{ AppRepositoryImpl(get()) }
}