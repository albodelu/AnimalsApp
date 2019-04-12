package com.alorma.animals.data

import com.alorma.animals.domain.AppRepository

class AppRepositoryImpl(
    private val appConfigDataSource: AppConfigDataSource
) : AppRepository {
    override suspend fun isOnBoardingDone(): Boolean =
        appConfigDataSource.onBoardingDone()
}