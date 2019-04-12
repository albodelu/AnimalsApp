package com.alorma.animals.extensions

operator fun <T> T.plus(list: Collection<T>): List<T> = mutableListOf(this).apply {
    addAll(list)
}.toList()