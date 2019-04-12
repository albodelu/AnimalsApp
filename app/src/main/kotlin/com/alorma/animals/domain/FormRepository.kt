package com.alorma.animals.domain

import com.alorma.animals.domain.model.FormField

interface FormRepository {

    suspend fun getFormFields(): List<FormField>
}