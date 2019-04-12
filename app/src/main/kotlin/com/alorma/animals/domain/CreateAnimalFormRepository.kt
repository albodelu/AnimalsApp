package com.alorma.animals.domain

import com.alorma.animals.domain.model.FormField

class CreateAnimalFormRepository: FormRepository {
    override suspend fun getFormFields(): List<FormField> {
        return emptyList()
    }
}