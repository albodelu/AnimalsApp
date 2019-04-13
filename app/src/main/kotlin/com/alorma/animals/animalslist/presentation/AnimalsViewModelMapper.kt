package com.alorma.animals.animalslist.presentation

import com.alorma.animals.animalslist.presentation.model.AnimalViewModel
import com.alorma.animals.domain.model.Animal
import com.alorma.animals.domain.model.FormField
import com.alorma.animals.extensions.plus
import java.text.SimpleDateFormat

class AnimalsViewModelMapper(
    private val dateFormat: SimpleDateFormat
) {
    fun map(
        animals: List<Animal>,
        formFields: List<FormField.IdValue>
    ): List<AnimalViewModel> = animals.groupBy { it.type }.map { item ->
        val title = formFields.firstOrNull { it.id == item.key }?.name ?: item.key
        AnimalViewModel.HeaderViewModel(title) + item.value.map { mapAnimal(it) }
    }.flatten()

    private fun mapAnimal(animal: Animal): AnimalViewModel.AnimalItemViewModel =
        AnimalViewModel.AnimalItemViewModel(
            animal.id,
            animal.name,
            dateFormat.format(animal.createdAt)
        )
}