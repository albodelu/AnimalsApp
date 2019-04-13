package com.alorma.animals.domain

import com.alorma.animals.R
import com.alorma.animals.domain.model.FormField
import com.alorma.animals.resources.ResourceProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AnimalFormRepository(
    private val resourceProvider: ResourceProvider
) {

    suspend fun getAnimalTypeFormFields(): List<FormField.IdValue> =
        withContext(Dispatchers.IO) {
            val ids = resourceProvider.getStringArray(R.array.animal_type)
            val names = resourceProvider.getStringArray(R.array.animal_type_names)

            ids.mapIndexed { index, id ->
                id to names[index]
            }.map { (id, name) ->
                FormField.IdValue(id, name)
            }
        }
}