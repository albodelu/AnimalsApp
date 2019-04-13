package com.alorma.animals.animalslist.presentation.model

sealed class AnimalViewModel {
    data class HeaderViewModel(val title: String) : AnimalViewModel()
    data class AnimalItemViewModel(
        val id: String,
        val name: String,
        val createdDate: String
    ) : AnimalViewModel()

}