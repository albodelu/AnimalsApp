package com.alorma.animals.data

import com.alorma.animals.R
import com.alorma.animals.domain.FormRepository
import com.alorma.animals.domain.model.FormField
import com.alorma.animals.resources.ResourceProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CreateAnimalFormRepository(
    private val resourceProvider: ResourceProvider
) : FormRepository {

    override suspend fun getAnimalTypeFormFields(): List<FormField.IdValue> =
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