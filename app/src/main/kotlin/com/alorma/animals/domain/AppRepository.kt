package com.alorma.animals.domain

interface AppRepository {
    suspend fun isOnBoardingDone(): Boolean
}