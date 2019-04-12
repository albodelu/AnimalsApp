package com.alorma.animals.domain

import com.alorma.animals.R
import com.alorma.animals.domain.model.FormField
import com.alorma.animals.resources.ResourceProvider

class CreateAnimalFormRepository(
    private val resourceProvider: ResourceProvider
): FormRepository {

    override suspend fun getFormFields(): List<FormField> =
        listOf(createAnimalTypeForm())

    private fun createAnimalTypeForm(): FormField.Selector {
        val ids = resourceProvider.getStringArray(R.array.animal_type)
        val names = resourceProvider.getStringArray(R.array.animal_type_names)

        val animalTypes = ids.mapIndexed { index, id ->
            id to names[index]
        }.map { (id, name) ->
            FormField.IdValue(id, name)
        }

        return FormField.Selector("type", animalTypes)
    }
}